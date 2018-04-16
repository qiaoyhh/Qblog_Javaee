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

import com.qyh.myblog_javaee.model.VideoBean;
import com.qyh.myblog_javaee.model.VideoTypeBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口名： VideoMapper
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月30日 14:03
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.g7.com.cn Inc. All rights reserved
 */
@Mapper
public interface VideoMapper {

    // 视频分类
    List<VideoTypeBean> findVideoTypeList();

    //视频列表

    List<VideoBean> findVideoDataList();
}