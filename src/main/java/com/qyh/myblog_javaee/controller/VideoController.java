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
import com.qyh.myblog_javaee.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类  名： VideoController
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月30日 14:06
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@RestController
@RequestMapping(value = "/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/getvideotypelist", method = RequestMethod.GET)
    public BaseBean getVideoTypeList() {
        return videoService.getVideoTypeList();
    }

    @RequestMapping(value = "/getvideodatalist", method = RequestMethod.GET)
    public BaseBean getVideoDataList(int page, int pageSize) {
        return videoService.getVideoDataList(page, pageSize);
    }
}