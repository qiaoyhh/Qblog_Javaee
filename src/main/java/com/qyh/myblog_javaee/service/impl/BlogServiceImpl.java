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
import com.qyh.myblog_javaee.mapper.BlogMapper;
import com.qyh.myblog_javaee.model.*;
import com.qyh.myblog_javaee.service.BlogService;
import com.qyh.myblog_javaee.utils.QUtils;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 类  名： BlogServiceImpl
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 16:55
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    private List<BlogBean> blogBeanList;

    @Override
    public BaseBean getBlogListById(String userId) {

        List<BlogBean> listByUserId = blogMapper.findBlogListByUserId(userId);
        if (listByUserId != null && listByUserId.size() > 0) {
            return BaseBean.success(listByUserId);
        } else {
            List emptyList = QUtils.createBlogEmptyList();
            return BaseBean.success("没有数据", listByUserId);
        }
    }

    @Override
    public BaseBean getBlogListByType(int type, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        if (type == 0) { //全部列表
            blogBeanList = blogMapper.findBlogListAll();
        } else {

            blogBeanList = blogMapper.findBlogListByType(type);
        }

        if (blogBeanList != null && blogBeanList.size() > 0) {
            return BaseBean.success(blogBeanList);
        } else {
            List emptyList = QUtils.createBlogEmptyList();
            return BaseBean.success("没有更多数据", emptyList);
        }
    }


    @Override
    public BaseBean getBlogTypeList() {
        List<BlogTypeBean> blogTypeList = blogMapper.findBlogTypeList();
        if (blogTypeList != null && blogTypeList.size() > 0) {
            return BaseBean.success(blogTypeList);
        } else {
            return BaseBean.error("获取数据失败", null);
        }
    }

    @Override
    public BaseBean addBlog(Map blogBean) {
        int addBlog = blogMapper.addBlog(blogBean);
        System.out.println("addBlog=" + addBlog);
        if (addBlog >= 1) {
            return BaseBean.success("上传成功", null);
        } else {
            return BaseBean.error("上传失败", null);
        }
    }

    @Override
    public BaseBean getBlogDetail(int id) {
        BlogDetailBean blogDetail = blogMapper.findBlogDetail(id);
        if (blogDetail != null) {
            return BaseBean.success(blogDetail);
        } else {
            return BaseBean.error("获取详情失败", null);
        }
    }

}