package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.mapper.BlogCommentMapper;
import com.muyi.blog.my.core.service.CommentService;
import com.muyi.blog.my.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 历川
 * @version 1.0
 * @description 博客评论接口实现类
 * @date 2023/8/10 11:26
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    BlogCommentMapper blogCommentMapper;
    @Override
    public Result getTotalComments() {
        return Result.ok(blogCommentMapper.getTotalComments(null));
    }
}
