/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.qyh.myblog_javaee.service.impl;


import com.qyh.myblog_javaee.mapper.UserMapper;
import com.qyh.myblog_javaee.model.BaseBean;
import com.qyh.myblog_javaee.model.UserInfoBean;
import com.qyh.myblog_javaee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * 类  名： UserServiceImpl
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 8:25
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseBean login(String phone, String password) {
        UserInfoBean userInfoBean = userMapper.login(phone, password);
        if (userInfoBean != null) {
            return BaseBean.success(userInfoBean);
        } else {
            return BaseBean.error("密码错误或没有注册", null);
        }
    }

    @Transactional // 开启事物
    @Override
    public BaseBean addUserInfo(String phone, String password,String userName) {
        if (!getPhoneIsRegist(phone)) {
            UserInfoBean userInfoBean = new UserInfoBean();
            String userID = UUID.randomUUID().toString();
            userInfoBean.setPhone(phone);
            userInfoBean.setPassword(password);
            userInfoBean.setUserId(userID);
            userInfoBean.setUserName(userName);
            Integer lineCount = userMapper.addUserInfo(userInfoBean);
            if (lineCount != null && lineCount != 0) {
                System.out.println("注册成功");
                return BaseBean.success("注册成功", null);
            } else {
                System.out.println("注册失败，请重试！");
                return BaseBean.error("注册失败，请重试！", null);
            }
        } else {
            System.out.println("该账号已注册");
            return BaseBean.error("该账号已注册", null);
        }
    }

    @Override
    public BaseBean getUserInfoById(String userId) {
        UserInfoBean userInfoBean = userMapper.queryPasswordById(userId);
        if (userInfoBean != null) {
            return BaseBean.success(userInfoBean);
        } else {
            return BaseBean.error("没有此用户", null);
        }
    }

    @Override
    public boolean getPhoneIsRegist(String phone) {
        String password = userMapper.queryUserIdByPhone(phone);
        if (password != null) {
            return true;
        } else {
            return false;
        }
    }
}