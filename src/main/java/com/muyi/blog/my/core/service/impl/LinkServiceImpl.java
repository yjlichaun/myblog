package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.mapper.BlogLinkMapper;
import com.muyi.blog.my.core.service.LinkService;
import com.muyi.blog.my.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 历川
 * @version 1.0
 * @description 链接接口实现类
 * @date 2023/8/10 11:19
 */
@Service
@Slf4j
public class LinkServiceImpl implements LinkService {
    
    
    @Autowired
    BlogLinkMapper blogLinkMapper;
    @Override
    public Result getTotalLinks() {
        return Result.ok(blogLinkMapper.getTotalLinks(null));
    }
}
