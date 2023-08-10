package com.muyi.blog.my.core.service;


import com.muyi.blog.my.core.util.Result;

/**
 * 博客类型接口
 *
 * @author 历川
 * @date 2023-08-10 10:51:09
 */
public interface CategoryService {
    
    /**
     * 获取类别总数
     * @return 数量
     */
    Result getTotalCategories();
    
    /**
     * 获取全部博客内容
     * @return Result
     */
    Result getAllCategories();
}
