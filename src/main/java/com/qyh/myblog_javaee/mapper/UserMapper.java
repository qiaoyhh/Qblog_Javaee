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

package com.qyh.myblog_javaee.mapper;

import com.qyh.myblog_javaee.model.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 接口 名： UserMapper
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 8:18
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.g7.com.cn Inc. All rights reserved
 */
@Mapper
public interface UserMapper {
    List<UserInfoBean> findUserInfo();

    Integer addUserInfo(UserInfoBean userBean);

    UserInfoBean queryPasswordById(@Param("userId") String userId);

    // 多参数方法必须 加 @Param ibatis这个包下面
    UserInfoBean login(@Param("phone") String phone, @Param("password") String password);

    String queryUserIdByPhone(@Param("phone") String phone);
}