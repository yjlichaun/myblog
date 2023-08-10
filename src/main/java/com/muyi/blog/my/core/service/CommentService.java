package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;

/**
 * @author 历川
 * @version 1.0
 * @description 评论接口
 * @date 2023/8/10 11:26
 */
public interface CommentService {
    
    /**
     * 获取评论数量
     */
    Result getTotalComments();
}
