package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.Blog;
import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 历川
 * @version 1.0
 * @description 博客mapper
 * @date 2023/8/10 11:05
 */
@Mapper
public interface BlogMapper {
    
    /**
     * 获取博客总数量
     * @param pageUtil 分页参数
     * @return 博客数量
     */
    int getTotalBlogs(PageQueryUtil pageUtil);
    
    /**
     * 根据分页参数获取博客列表
     * @param pageUtil 分页参数
     * @return 博客列表
     */
    
    List<Blog> findBlogList(PageQueryUtil pageUtil);
    
    /**
     * 根据博客id获取博客
     * @param blogId 博客id
     * @return 博客对象
     */
    @ResultMap("BaseResultMap")
    @Select("select * from tb_blog where blog_id = #{blogId} ")
    Blog getBlogById(@Param("blogId") Long blogId);
    
    /**
     * 更新blog
     * @param blog blog对象
     * @return 影响行数
     */
    int updateBlog(Blog blog);
    
    /**
     * 新增博客
     * @param record 博客
     * @return 影响行数
     */
    int insertSelective(Blog record);
}
