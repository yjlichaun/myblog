package com.muyi.blog.my.core.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签计数
 * @date 2023/8/9 11:18
 */
@Data
public class BlogTagCount {
    
    /**
     * 标签id
     */
    private Integer tagId;
    
    /**
     * 标签名称
     */
    private String tagName;
    
    /**
     * 标签数量
     */
    private Integer tagCount;
    
    
    
}
