package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.entity.BlogComment;
import com.muyi.blog.my.core.mapper.BlogCommentMapper;
import com.muyi.blog.my.core.service.CommentService;
import com.muyi.blog.my.core.util.PageQueryUtil;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客评论接口实现类
 * @date 2023/8/10 11:26
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    BlogCommentMapper blogCommentMapper;
    @Override
    public Result getTotalComments() {
        return Result.ok(blogCommentMapper.getTotalComments(null));
    }
    
    @Override
    public Result getCommentsPage(Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return Result.failed("参数异常!");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<BlogComment> commentList =  blogCommentMapper.getCommentsList(pageUtil);
        int totalComments = blogCommentMapper.getTotalComments(pageUtil);
        PageResult pageResult = new PageResult(commentList,totalComments,pageUtil.getLimit(),pageUtil.getPage());
        return Result.ok(pageResult,"查询成功!!!");
    }
    
    @Override
    public Result checkDone(Integer[] ids) {
        if (ids == null || ids.length < 1 ) {
            return Result.failed("至少需要一个评论");
        }
        if (blogCommentMapper.checkDone(ids) > 0) {
            return Result.ok("已经通过审核");
        }
        return Result.failed("审核失败!!!");
    }
    
    @Override
    public Result reply(CommentVo commentVo) {
        Long commentId = commentVo.getCommentId();
        String commentBody = commentVo.getCommentBody();
        if (commentId == null || commentId < 1 || !StringUtils.hasText(commentBody)) {
            return Result.failed("参数异常！！！");
        }
        BlogComment comment = blogCommentMapper.selectByCommentId(commentId);
        if (comment != null && comment.getCommentStatus().intValue() == 1){
            comment.setReplyBody(commentBody);
            comment.setReplyCreateTime(new Date());
            if (blogCommentMapper.updateComment(comment) > 0) {
                return Result.ok("回复成功！！！");
            }
        }
        return Result.failed("回复失败！！！");
    }
    
    @Override
    public Result deleteCommentByIds(Integer[] ids) {
        if (ids == null || ids.length < 1) {
            return Result.failed("参数异常");
        }
        if (blogCommentMapper.deleteCommentByIds(ids) > 0) {
            return Result.ok("删除成功！！！");
        }
        return Result.failed("删除失败");
    }
}
