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

package com.qyh.myblog_javaee.controller;


import com.qyh.myblog_javaee.model.BaseBean;
import com.qyh.myblog_javaee.model.ResourceBean;
import com.qyh.myblog_javaee.model.UserInfoBean;
import com.qyh.myblog_javaee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * 类  名： UserController
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 7:45
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService mUserService;

    @Autowired
    private ResourceBean resourceBean;

    /**
     * 注册
     * @param phone
     * @param password
     * @param userName
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public BaseBean addUserInfo(String phone, String password, String userName) {
        if (phone != null && password != null && userName != null) {
            return mUserService.addUserInfo(phone, password, userName);
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public BaseBean loginTest(String phone, String password) {
        if (phone != null && password != null) {
            return mUserService.login(phone, password);
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    /**
     * 获取用户信息
     * @param userid
     * @return
     */
    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    public BaseBean getUserInfo(String userid) {
        if (userid != null) {
            return mUserService.getUserInfoById(userid);
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public BaseBean test(){
        return BaseBean.success("测试成功");
    }
}