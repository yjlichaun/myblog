package com.muyi.blog.my.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 博客配置
 * @date 2023/8/9 11:10
 */
@Data
@ToString
public class BlogConfig {
    
    /**
     * 配置名称
     */
    private String configName;
    
    /**
     * 配置信息
     */
    private String configValue;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }
    
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
