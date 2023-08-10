package com.muyi.blog.my.core.mapper;


import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 博客类别mapper
 * @author 历川
 * @date 2023-08-10 10:55:24
 */
@Mapper
public interface BlogCategoryMapper {
    
    /**
     * 获取博客类别总数
     * @param pageUtil 分页数据
     * @return 总数
     */
    @Select("select count(*) from tb_blog_category where is_deleted = 0")
    int getTotalCategories(PageQueryUtil pageUtil);
    
    /**
     * 获取全部博客内容
     * @return 列表
     */
    List<BlogCategory> getAllCategories(PageQueryUtil pageUtil);
    
    /**
     * 根据博客类别id获取博客类别对象
     * @param blogCategoryId 博客类别id
     * @return 博客类别对象
     */
    BlogCategory selectByPrimaryKey(Integer blogCategoryId);
    
    /**
     * 更新博客类别
     * @param record 博客对象
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(BlogCategory record);
}
