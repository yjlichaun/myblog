package com.muyi.blog.my.core.config;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 历川
 * @version 1.0
 * @description Sa-Token全局异常拦截器
 * @date 2023/8/10 16:28
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }
}
