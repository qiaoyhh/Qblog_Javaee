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

/**
 * 类  名： BaseBean
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 9:28
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
public class BaseBean {

    private String status_code;
    private String msg;
    private Object data;

    public BaseBean(String status_code, String msg, Object data) {
        this.status_code = status_code;
        this.msg = msg;
        this.data = data;
    }

    public BaseBean(Object data, String status_code) {
        this.status_code = status_code;
        this.msg = "请求成功";
        this.data = data;
    }

    public static BaseBean success(Object data) {
        return new BaseBean(data, "1");
    }

    public static BaseBean success(String msg, Object data) {
        return new BaseBean("1", msg, data);
    }

    public static BaseBean error(String msg, Object data) {
        return new BaseBean("0", msg, data);
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "status_code='" + status_code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}