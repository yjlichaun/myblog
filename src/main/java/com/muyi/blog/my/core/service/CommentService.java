package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CommentVo;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 评论接口
 * @date 2023/8/10 11:26
 */
public interface CommentService {
    
    /**
     * 获取评论数量
     */
    Result getTotalComments();
    
    /**
     * 根据分页参数获取评论列表
     * @param params 分页参数
     * @return Result
     */
    Result getCommentsPage(Map<String, Object> params);
    
    /**
     * 根据评论id列表审核评论
     * @param ids 评论列表id
     * @return Result
     */
    Result checkDone(Integer[] ids);
    
    /**
     * 回复评论
     * @param commentVo 回复Vo
     * @return Result
     */
    Result reply(CommentVo commentVo);
}
