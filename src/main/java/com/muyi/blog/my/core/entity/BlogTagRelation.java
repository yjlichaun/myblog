package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签关系
 * @date 2023/8/9 11:20
 */
@Data
@ToString
public class BlogTagRelation {
    
    /**
     * 关系id
     */
    private Long relationId;
    
    /**
     * 博客id
     */
    private Long blogId;
    
    /**
     * 标签id
     */
    private Integer tagId;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
}
