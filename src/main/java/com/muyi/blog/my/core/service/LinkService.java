package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.entity.BlogLink;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.LinkVo;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 链接接口
 * @date 2023/8/10 11:19
 */
public interface LinkService {
    
    /**
     * 获取链接总数
     * @return 链接总数
     */
    Result getTotalLinks();
    
    /**
     * 获取博客链接列表
     * @param params 分页参数
     * @return result
     */
    Result getBlogLinkList(Map<String, Object> params);
    
    /**
     * 添加友链
     * @param linkVo 友链对象
     * @return Result
     */
    Result saveLink(LinkVo linkVo);
    
    /**
     * 根据链接id获取链接
     * @param id 链接id
     * @return  Result
     */
    Result getLinkInfoById(Integer id);
    
    /**
     * 修改友链
     * @param blogLink 友链对象
     * @return Result
     */
    Result updateLink(BlogLink blogLink);
    
    /**
     * 删除友链
     * @param ids 友链id列表
     * @return Result
     */
    Result deleteLinkByIds(Integer[] ids);
}
