package com.muyi.blog.my.core.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客列表vo类
 * @date 2023/8/14 19:27
 */
@Data
public class BlogListVo {
    
    /**
     * 博客id
     */
    private Long blogId;
    
    /**
     * 博客标题
     */
    private String blogTitle;
    /**
     * 博客自定义url
     */
    private String blogSubUrl;
    
    /**
     * 博客封面
     */
    private String blogCoverImage;
    
    /**
     * 博客分类id
     */
    private Integer blogCategoryId;
    
    
    /**
     * 博客分类图标
     */
    private String blogCategoryIcon;
    
    /**
     * 博客分类名称
     */
    private String blogCategoryName;
    
    
    /**
     * 博客创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}
