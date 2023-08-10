package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;

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
}
