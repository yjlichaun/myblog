package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;

/**
 * @author 历川
 * @version 1.0
 * @description 配置服务
 * @date 2023/8/12 14:52
 */
public interface ConfigService {
    
    /**
     * 修改配置项
     *
     * @param configName 配置名称
     * @param configValue 配置值
     * @return 影响行数
     */
    int updateConfig(String configName, String configValue);
}
