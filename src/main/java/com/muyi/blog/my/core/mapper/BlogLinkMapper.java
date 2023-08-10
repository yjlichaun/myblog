package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 历川
 * @version 1.0
 * @description 博客链接mapper
 * @date 2023/8/10 11:23
 */
@Mapper
public interface BlogLinkMapper {
    
    /**
     * 获取博客链接总数
     * @param pageUtil 分页参数
     * @return 数量
     */
    @Select("select  count(*) from tb_link where is_deleted = 0")
    int getTotalLinks(PageQueryUtil pageUtil);
}
