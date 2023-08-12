package com.muyi.blog.my.core.vo;

import lombok.Data;

/**
 * @author 历川
 * @version 1.0
 * @description 链接vo类
 * @date 2023/8/12 15:32
 */

@Data
public class LinkVo {
    
    /**
     * 链接类型
     */
    private Integer linkType;
    /**
     * 链接名称
     */
    private String linkName;
    
    /**
     * 链接url
     */
    private String linkUrl;
    /**
     * 链接排名
     */
    private Integer linkRank;
    /**
     * 链接描述
     */
    private String linkDescription;
    
}
