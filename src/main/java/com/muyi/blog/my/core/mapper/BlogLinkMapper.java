package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.BlogLink;
import com.muyi.blog.my.core.util.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    
    /**
     * 根据分页参数获取链接列表
     * @param pageUtil 分页参数
     * @return 列表
     */
    List<BlogLink> getBlogLinkList(PageQueryUtil pageUtil);
    
    /***
     * 添加链接
     * @param blogLink 链接对象
     * @return 影响行数
     */
    
    int insertLink(BlogLink blogLink);
    
    /**
     * 获取链接详情
     * @param id 链接id
     * @return Result
     */
    @ResultMap("BaseResultMap")
    @Select("select * from tb_link where link_id = #{id} and is_deleted = 0")
    BlogLink getLinkInfoById(@Param("id") Integer id);
    
    /**
     * 修改友链
     * @param blogLink 友链对象
     * @return Result
     */
    int updateLink(BlogLink blogLink);
    
    /**
     * 删除友链
     * @param ids 友链id列表
     * @return Result
     */
    int deleteLink(Integer[] ids);
}
