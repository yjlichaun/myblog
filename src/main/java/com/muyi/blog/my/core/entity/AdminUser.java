package com.muyi.blog.my.core.entity;

import lombok.Data;

/**
 * @author 历川
 * @version 1.0
 * @description 用户类
 * @date 2023/8/9 10:27
 */
@Data
public class AdminUser {
    
    /**
     * 用户id
     */
    private Integer adminUserId;
    
    /**
     * 登录用户名
     */
    private String loginUserName;
    
    /**
     * 登录密码
     */
    private String loginPassword;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 锁
     */
    private Byte locked;
    
    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", nickName=").append(nickName);
        sb.append(", locked=").append(locked);
        sb.append("]");
        return sb.toString();
    }
}
