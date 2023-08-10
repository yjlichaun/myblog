package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;

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
}
