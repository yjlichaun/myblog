package com.muyi.blog.my.core.util;

import lombok.*;

import java.io.Serializable;

/**
 * @author 历川
 * @version 1.0
 * @description 统一返回类
 * @date 2023/8/7 12:06
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Getter
    @Setter
    private int code;
    
    @Getter
    @Setter
    private String msg;
    
    @Getter
    @Setter
    private T data;
    
    public static <T> Result<T> ok() {
        return restResult(null, ResultGenerator.RESULT_CODE_SUCCESS, ResultGenerator.DEFAULT_SUCCESS_MESSAGE);
    }
    
    public static <T> Result<T> ok(T data) {
        return restResult(data, ResultGenerator.RESULT_CODE_SUCCESS, ResultGenerator.DEFAULT_SUCCESS_MESSAGE);
    }
    
    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, ResultGenerator.RESULT_CODE_SUCCESS, msg);
    }
    
    public static <T> Result<T> ok (String msg) {return restResult(null, ResultGenerator.RESULT_CODE_SUCCESS,msg);}
    
    public static <T> Result<T> failed() {
        return restResult(null, ResultGenerator.RESULT_CODE_SERVER_ERROR, ResultGenerator.DEFAULT_FAIL_MESSAGE);
    }
    
    public static <T> Result<T> failed(String msg) {
        return restResult(null,ResultGenerator.RESULT_CODE_SERVER_ERROR, msg);
    }
    
    public static <T> Result<T> failed(T data) {
        return restResult(data, ResultGenerator.RESULT_CODE_SERVER_ERROR, ResultGenerator.DEFAULT_FAIL_MESSAGE);
    }
    
    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, ResultGenerator.RESULT_CODE_SERVER_ERROR, msg);
    }
    public static <T> Result<T> failed(T data, int code, String msg) {
        return restResult(data, code, msg);
    }
    
    public static <T> Result<T> result(T data, int code, String msg) {
        return restResult(data, code, msg);
    }
    
    public static <T> Result<T> error(T data, int code, String msg) {
        return restResult(data, code, msg);
    }
    
    public static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
    
    public Boolean isSuccess() {
        return (this.code == ResultGenerator.RESULT_CODE_SUCCESS);
    }
    
}
