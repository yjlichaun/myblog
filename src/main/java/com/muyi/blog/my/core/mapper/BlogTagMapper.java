package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogTag;
import com.muyi.blog.my.core.entity.BlogTagCount;
import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签mapper
 * @date 2023/8/10 11:30
 */
@Mapper
public interface BlogTagMapper {
    
    /**
     * 获取博客标签总数
     * @param pageUtil 分页参数
     * @return 总数
     */
    @Select("select  count(*) from tb_blog_tag where is_deleted = 0")
    int getTotalTags(PageQueryUtil pageUtil);
    
    /**
     * 根据标签名称获取标签对象
     * @param tagName 标签名称
     * @return 标签
     */
    BlogTag selectByTagName(String tagName);
    
    /**
     * 绑定标签
     * @param tagList 标签列表
     */
    void batchInsertBlogTag(List<BlogTag> tagList);
    
    /**
     * 获取标签列表
     * @param pageUtil 分页参数
     * @return result
     */
    List<BlogTag> getTagList(PageQueryUtil pageUtil);
    
    /**
     * 添加标签
     * @param tag 标签对象
     * @return result
     */
    int insertTag(BlogTag tag);
    
    /**
     * 根据id删除标签
     * @param ids ids
     * @return 影响行数
     */
    int deleteTagByIds(Integer[] ids);
    
    /**
     * 获取标签列表
     * @return 列表
     */
    List<BlogTagCount> getTagCount();
}
