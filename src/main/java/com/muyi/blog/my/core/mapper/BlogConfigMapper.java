package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @author 历川
 * @version 1.0
 * @description 博客配置mapper
 * @date 2023/8/10 11:35
 */
@Mapper
public interface BlogConfigMapper {
    
    /**
     * 根据配置名称获取配置
     * @param configName 配置名称
     * @return BlogConfig
     */
    
    @ResultMap("BaseResultMap")
    @Select("select * from tb_config where config_name = #{configName}")
    BlogConfig selectByName(@Param("configName") String configName);
    
    /**
     * 更新配置
     * @param blogConfig 配置
     * @return 影响行数
     */
    int updateConfig(BlogConfig blogConfig);
}
