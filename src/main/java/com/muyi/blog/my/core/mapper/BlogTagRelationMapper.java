package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogTagRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签关系标签
 * @date 2023/8/10 11:37
 */
@Mapper
public interface BlogTagRelationMapper {
    
    
    /**
     * 绑定标签和博客关系
     * @param blogTagRelations 关系
     * @return  影响行数
     */
    int batchInsert(@Param("relationList") List<BlogTagRelation> blogTagRelations);
}
