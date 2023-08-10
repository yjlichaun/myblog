package com.muyi.blog.my.core.service;

import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.LoginUserVo;

/**
 * @author 历川
 * @version 1.0
 * @description 后台用户接口
 * @date 2023/8/10 14:52
 */

public interface AdminUserService {
    
    /**
     * 后台用户登录
     * @param userVo 用户登录信息
     * @return Result
     */
    Result login(LoginUserVo userVo);
    
    /**
     * 修改用户密码
     * @param loginUserId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return Result
     */
    Result updatePassword(Integer loginUserId, String oldPassword, String newPassword);
    
    /**
     * 修改昵称
     * @param loginUserId 用户id
     * @param nickname 昵称
     * @return Result
     */
    Result updateNickName(Integer loginUserId, String nickname);
}
