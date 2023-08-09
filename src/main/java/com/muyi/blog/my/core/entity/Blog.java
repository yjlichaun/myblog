package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客类
 * @date 2023/8/9 10:30
 */

@Data
@ToString
public class Blog {
    /**
     * 博客id
     */
    private Long blogId;
    
    /**
     * 博客标题
     */
    private String blogTitle;
    
    /**
     * 博客url
     */
    private String blogSubUrl;
    
    /**
     * 博客封面图片
     */
    private String blogCoverImage;
    
    /**
     * 博客分类id
     */
    private Integer blogCategoryId;
    
    /**
     * 博客分类名称
     */
    private String blogCategoryName;
    
    /**
     * 博客标签
     */
    private String blogTags;
    
    /**
     * 博客状态
     */
    private Byte blogStatus;
    
    /**
     * 博客观看量
     */
    private Long blogViews;
    
    /**
     * 启用注释
     */
    private Byte enableComment;
    
    /**
     * 是否删除
     */
    private Byte isDeleted;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 博客内容
     */
    private String blogContent;
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }
    
    public void setBlogSubUrl(String blogSubUrl) {
        this.blogSubUrl = blogSubUrl == null ? null : blogSubUrl.trim();
    }
    
    public void setBlogCoverImage(String blogCoverImage) {
        this.blogCoverImage = blogCoverImage == null ? null : blogCoverImage.trim();
    }
    
    public void setBlogCategoryName(String blogCategoryName) {
        this.blogCategoryName = blogCategoryName == null ? null : blogCategoryName.trim();
    }
    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags == null ? null : blogTags.trim();
    }
    
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
    
}
