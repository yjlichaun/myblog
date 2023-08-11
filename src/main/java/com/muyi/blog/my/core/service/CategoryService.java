package com.muyi.blog.my.core.service;


import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CategoryVo;

import java.util.Map;

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
    
    /**
     * 获取分类列表
     * @param params 分页参数
     * @return Result
     */
    Result getBlogCategoryList(Map<String, Object> params);
    
    /**
     * 添加分类种类
     * @param categoryVo 种类vo类
     * @return Result
     */
    Result saveCategory(CategoryVo categoryVo);
    
    /**
     * 更新博客种类
     * @param category 博客种类对象
     * @return Result
     */
    
    Result updateCategory(BlogCategory category);
    
    /**
     * 根据id列表删除对应分类
     * @param ids id列表
     * @return  Result
     */
    Result deleteCategories(Integer[] ids);
}
