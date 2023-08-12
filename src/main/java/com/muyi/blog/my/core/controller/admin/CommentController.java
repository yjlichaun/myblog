package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.service.CommentService;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CommentVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 评论controller
 * @date 2023/8/11 17:02
 */
@RestController
@RequestMapping("/admin")
public class CommentController {
    
    @Autowired
    CommentService commentService;
    
    /**
     * 根据分页参数获取评论列表
     * @param params 分页参数
     * @return Result
     */
    @GetMapping("/comments/list")
    public Result list(@RequestBody Map<String, Object> params) {
        return commentService.getCommentsPage(params);
    }
    
    /**
     * 审核评论
     * @param ids 评论id列表
     * @return Result
     */
    @PostMapping("/comments/checkDone")
    public Result checkDone(@RequestBody Integer[] ids) {
        return commentService.checkDone(ids);
    }
    
    
    /**
     * 回复评论
     * @param commentVo 回复Vo
     * @return Result
     */
    @PostMapping("/comments/reply")
    public Result reply(@RequestBody CommentVo commentVo) {
        return commentService.reply(commentVo);
    }
    
    /**
     * 删除评论
     * @param ids 评论id
     * @return Result
     */
    @DeleteMapping("/comments/delete")
    public Result delete(@RequestBody Integer[] ids) {
        return commentService.deleteCommentByIds(ids);
    }
}
