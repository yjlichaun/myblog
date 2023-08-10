package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;

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
}
