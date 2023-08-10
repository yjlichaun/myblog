package com.muyi.blog.my.core.vo;

import lombok.Data;

/**
 * @author 历川
 * @version 1.0
 * @description 登录用户Vo类
 * @date 2023/8/10 14:40
 */
@Data
public class LoginUserVo {
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 密码
     */
    private String password;
    
    /**
     * 验证码
     */
    private String verifyCode;
}
