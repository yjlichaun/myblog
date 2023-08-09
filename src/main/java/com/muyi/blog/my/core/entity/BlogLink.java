package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客链接
 * @date 2023/8/9 11:13
 */
@Data
@ToString
public class BlogLink {
    /**
     * 链接id
     */
    private Integer linkId;
    
    /**
     * 链接类型
     */
    private Byte linkType;
    
    /**
     * 链接名称
     */
    private String linkName;
    
    /**
     * 链接url
     */
    private String linkUrl;
    
    /**
     * 连接描述
     */
    private String linkDescription;
    
    /**
     * 链接排名
     */
    private Integer linkRank;
    
    /**
     * 是否删除
     */
    private Byte isDeleted;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    
    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }
    
    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }
    
    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription == null ? null : linkDescription.trim();
    }
    
}
