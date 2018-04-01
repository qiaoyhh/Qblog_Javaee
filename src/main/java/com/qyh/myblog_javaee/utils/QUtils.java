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

package com.qyh.myblog_javaee.utils;

import com.qyh.myblog_javaee.model.BlogBean;
import com.qyh.myblog_javaee.model.VideoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类  名： QUtils
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月29日 16:58
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
public class QUtils {

    public static List createBlogEmptyList() {
        List<BlogBean> blogBeanList = new ArrayList<>();
        BlogBean blogBean = new BlogBean();
        blogBean.setId(-1);
        blogBeanList.add(blogBean);
        return blogBeanList;
    }

    public static List createVideoEmptyList() {
        List<VideoBean> blogBeanList = new ArrayList<>();
        VideoBean videoBean = new VideoBean();
        videoBean.setId(-1);
        blogBeanList.add(videoBean);
        return blogBeanList;
    }
}