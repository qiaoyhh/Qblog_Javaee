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

package com.qyh.myblog_javaee.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 类  名： BlogBean
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 16:40
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.g7.com.cn Inc. All rights reserved
 */
public class BlogBean {

    private Integer id;
    private String UserId;
    private Integer type;
    @JsonFormat(pattern = "yyyy-MM-dd kk:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;
    private String title;
    private String content;
    private UserInfoBean userBean;


    public UserInfoBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserInfoBean userBean) {
        this.userBean = userBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogBean{" +
                "id=" + id +
                ", UserId=" + UserId +
                ", type=" + type +
                ", createTime=" + createTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userBean=" + userBean +
                '}';
    }
}