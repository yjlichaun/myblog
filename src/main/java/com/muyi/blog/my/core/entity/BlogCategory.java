package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客种类
 * @date 2023/8/9 10:44
 */
@Data
@ToString
public class BlogCategory {
    
    /**
     * 博客类型id
     */
    private Integer categoryId;
    
    /**
     * 博客类型名称
     */
    private String categoryName;
    
    /**
     * 博客种类图标
     */
    private String categoryIcon;
    
    /**
     * 博客种类排名
     */
    private Integer categoryRank;
    
    /**
     * 是否删除该种类
     */
    private Byte isDeleted;
    
    /**
     * 博客种类创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon == null ? null : categoryIcon.trim();
    }
}
