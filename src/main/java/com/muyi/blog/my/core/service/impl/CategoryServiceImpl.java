package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.mapper.BlogCategoryMapper;
import com.muyi.blog.my.core.service.CategoryService;
import com.muyi.blog.my.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 历川
 * @version 1.0
 * @description 博客类型接口实现类
 * @date 2023/8/10 10:51
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    BlogCategoryMapper blogCategoryMapper;
    @Override
    public Result getTotalCategories() {
        return Result.ok(blogCategoryMapper.getTotalCategories(null));
    }
    
    @Override
    public Result getAllCategories() {
        List<BlogCategory> list =  blogCategoryMapper.getAllCategories(null);
        return Result.ok(list,"查询成功！！！");
    }
}
