package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogComment;
import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 历川
 * @version 1.0
 * @description 博客评论mapper
 * @date 2023/8/10 11:33
 */
@Mapper
public interface BlogCommentMapper {
    
    /**
     * 获取评论总数
     * @param pageUtil 分页参数
     * @return 评论总数
     */
    int getTotalComments(PageQueryUtil pageUtil);
    
    /**
     * 根据分页参数获取全部评论
     * @param pageUtil 分页参数
     * @return 评论列表
     */
    
    
    List<BlogComment> getCommentsList(PageQueryUtil pageUtil);
    
    /**
     * 审核评论
     * @param ids id列表
     * @return 影响行数
     */
    int checkDone(Integer[] ids);
    
    /**
     * 根据id获取评论
     * @param commentId 评论id
     * @return 评论对象
     */
    @ResultMap("BaseResultMap")
    @Select("select * from  tb_blog_comment where comment_id = #{commentId}")
    BlogComment selectByCommentId(@Param("commentId") Long commentId);
    
    /**
     * 更新评论
     * @param comment 评论
     * @return 影响行数
     */
    int updateComment(BlogComment comment);
}
