package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.entity.BlogConfig;
import com.muyi.blog.my.core.mapper.BlogConfigMapper;
import com.muyi.blog.my.core.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 历川
 * @version 1.0
 * @description 配置服务接口实现类
 * @date 2023/8/12 14:52
 */
@Service
@Slf4j
public class ConfigServiceImpl implements ConfigService {
    
    @Autowired
    BlogConfigMapper configMapper;
    @Override
    public int updateConfig(String configName, String configValue) {
        BlogConfig blogConfig = configMapper.selectByName(configName);
        if (blogConfig != null) {
            blogConfig.setConfigValue(configValue);
            blogConfig.setUpdateTime(new Date());
            return configMapper.updateConfig(blogConfig);
        }
        return 0;
    }
}
