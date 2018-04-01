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
import com.qyh.myblog_javaee.model.BlogBean;
import com.qyh.myblog_javaee.model.BlogTypeBean;
import com.qyh.myblog_javaee.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 类  名： BlogController
 * 描  述：
 * 创建人： qyh
 * 日  期： 2018年03月17日 16:57
 * 版本号： 1.0
 * <p>
 * Copyright (c) 2018 www.youkb.net Inc. All rights reserved
 */
@RestController

@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 通过userID，获取博客列表
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getblogsbyid", method = RequestMethod.GET)
    public BaseBean getBlogsListById(String userId) {
        if (userId != null) {
            BaseBean listById = blogService.getBlogListById(userId);
            return listById;
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    /**
     * 添加博客
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addblog", method = RequestMethod.POST)
    public BaseBean addBlog(@RequestParam Map<String, String> map) {
        if (map != null) {
            String userId = map.get("userId");
            String type = map.get("type");
            String title = map.get("title");
            String content = map.get("content");
            String createTime = map.get("createTime");
            if (userId != null && type != null && title != null && content != null && createTime != null) {
                BaseBean baseBean = blogService.addBlog(map);
                return baseBean;
            } else {
                return BaseBean.error("请填写必要参数", null);
            }
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    /**
     * 获取全部列表
     *
     * @param type
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getbloglist", method = RequestMethod.GET)
    public BaseBean getBlogsListAll(int type, String page, String pageSize) {
        if (page != null && pageSize != null) {
            BaseBean blogListByType = blogService.getBlogListByType(type, Integer.valueOf(page), Integer.valueOf(pageSize));
            return blogListByType;
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }

    /**
     * 获取博客类型
     *
     * @return
     */
    @RequestMapping(value = "/getblogtype", method = RequestMethod.GET)
    public BaseBean getBlogType() {
        return blogService.getBlogTypeList();
    }

    /**
     * 获取博客详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getblogdetail", method = RequestMethod.GET)
    public BaseBean getBlogDetail(int id) {
        if (String.valueOf(id) != null) {
            return blogService.getBlogDetail(id);
        } else {
            return BaseBean.error("请填写必要参数", null);
        }
    }


}