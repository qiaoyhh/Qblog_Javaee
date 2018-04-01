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

import com.github.pagehelper.PageHelper;
import com.qyh.myblog_javaee.mapper.VideoMapper;
import com.qyh.myblog_javaee.model.BaseBean;
import com.qyh.myblog_javaee.model.BlogBean;
import com.qyh.myblog_javaee.model.VideoBean;
import com.qyh.myblog_javaee.model.VideoTypeBean;
import com.qyh.myblog_javaee.service.VideoService;
import com.qyh.myblog_javaee.utils.QUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类  名： VideoServiceImpl
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月30日 14:10
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Override
    public BaseBean getVideoTypeList() {
        List<VideoTypeBean> videoTypeList = videoMapper.findVideoTypeList();
        if (videoTypeList != null && videoTypeList.size() > 0) {
            return BaseBean.success(videoTypeList);
        } else {
            return BaseBean.error("获取数据失败", null);
        }
    }

    @Override
    public BaseBean getVideoDataList(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<VideoBean> videoDataList = videoMapper.findVideoDataList();
        if (videoDataList != null && videoDataList.size() > 0) {
            return BaseBean.success(videoDataList);
        } else {
            List emptyList = QUtils.createVideoEmptyList();
            return BaseBean.success("没有更多数据", emptyList);
        }
    }
}