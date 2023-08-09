package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客评论
 * @date 2023/8/9 11:06
 */
@Data
@ToString
public class BlogComment {
    
    /**
     * 评论id
     */
    private Long commentId;
    
    /**
     * 博客id
     */
    private Long blogId;
    
    /**
     * 评论人
     */
    private String commentator;
    
    /**
     * 评论邮箱
     */
    private String email;
    
    /**
     * 网站网址
     */
    private String websiteUrl;
    
    /**
     * 评论信息
     */
    private String commentBody;
    
    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentCreateTime;
    
    /**
     * 评论人ip
     */
    private String commentatorIp;
    
    /**
     * 回复信息
     */
    private String replyBody;
    
    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyCreateTime;
    
    /**
     * 评论状态
     */
    private Byte commentStatus;
    
    /**
     * 是否删除
     */
    private Byte isDeleted;
    
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    
    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl == null ? null : websiteUrl.trim();
    }
    
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody == null ? null : commentBody.trim();
    }
    
    public void setCommentatorIp(String commentatorIp) {
        this.commentatorIp = commentatorIp == null ? null : commentatorIp.trim();
    }
    
    public void setReplyBody(String replyBody) {
        this.replyBody = replyBody == null ? null : replyBody.trim();
    }
    
    
    
    
    
    
    
    
}
