package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 标签接口
 * @date 2023/8/10 11:25
 */
public interface TagService {
    
    /**
     * 获取标签总数
     * @return 标签总数
     */
    Result getTotalTags();
    
    /**
     * 获取标签列表
     * @param params 分页参数
     * @return result
     */
    Result getTagList(Map<String, Object> params);
    
    /**
     * 添加标签
     * @param tagName 标签名称
     * @return result
     */
    Result saveTag(String tagName);
    
    /**
     * 删除标签
     * @param ids 标签id列表
     * @return result
     */
    Result deleteTagByIds(Integer[] ids);
}
