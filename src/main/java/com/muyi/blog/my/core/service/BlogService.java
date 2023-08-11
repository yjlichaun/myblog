package com.muyi.blog.my.core.service;


import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.BlogVo;

import java.util.Map;

/**
 * 博客接口
 *
 * @author 历川
 * @date 2023-08-10 11:02:57
 */
public interface BlogService {
    
    /**
     * 获取博客数量
     * @return 数量
     */
    Result getTotalBlogs();
    
    /**
     * 获取博客内容,根据分页参数
     * @param params 分页参数
     * @return result
     */
    Result getBlogPage(Map<String, Object> params);
    
    /**
     * 编辑博客类别
     * @param blogId 博客id
     * @param blogCategory 博客类别
     * @return Result
     */
    Result editBlogCategory(Long blogId, BlogCategory blogCategory);
    
    /**
     * 保存博客(新增博客)
     * @param blogVo 博客
     * @return Result
     */
    Result save(BlogVo blogVo);
    
    /**
     * 根据博客id列表删除博客
     * @param ids id列表
     * @return Result
     */
    Result deleteBlogByIds(Integer[] ids);
}
