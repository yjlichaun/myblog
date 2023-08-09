package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签
 * @date 2023/8/9 11:16
 */
@Data
@ToString
public class BlogTag {
    
    /**
     * 标签id
     */
    private Integer tagId;
    
    /**
     * 标签名称
     */
    private String tagName;
    
    /**
     * 是否删除
     */
    private Byte isDeleted;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }
    
    
}
