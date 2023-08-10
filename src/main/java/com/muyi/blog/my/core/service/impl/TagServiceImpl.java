package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.mapper.BlogTagMapper;
import com.muyi.blog.my.core.service.TagService;
import com.muyi.blog.my.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签接口实现类
 * @date 2023/8/10 11:27
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {
    
    
    @Autowired
    BlogTagMapper blogTagMapper;
    @Override
    public Result getTotalTags() {
        return Result.ok(blogTagMapper.getTotalTags(null));
    }
}

