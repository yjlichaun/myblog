package com.muyi.blog.my.core.vo;

import lombok.Data;

/**
 * @author 历川
 * @version 1.0
 * @description 博客对象vo类
 * @date 2023/8/10 21:18
 */
@Data
public class BlogVo {
    /**
     * 博客标题
     */
    private String blogTitle;
    /**
     * 博客自定义url
     */
    private String blogSubUrl;
    /**
     * 博客类别id
     */
    private Integer blogCategoryId;
    
    /**
     * 博客标签
     */
    private String blogTags;
    
    /**
     * 博客内容
     */
    private String blogContent;
    
    /**
     * 博客封面
     */
    private String blogCoverImage;
    
    /**
     * 博客状态
     */
    private Byte blogStatus;
    /**
     * 是否可评论
     */
    private Byte enableComment;
    
}
