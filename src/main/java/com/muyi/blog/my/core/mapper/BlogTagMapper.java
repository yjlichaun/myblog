package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogTag;
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
}
