package com.muyi.blog.my.core.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.muyi.blog.my.core.entity.AdminUser;
import com.muyi.blog.my.core.mapper.AdminUserMapper;
import com.muyi.blog.my.core.service.AdminUserService;
import com.muyi.blog.my.core.util.MD5Util;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.LoginUserVo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author 历川
 * @version 1.0
 * @description 后台用户接口实现类
 * @date 2023/8/10 14:53
 */
@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {
    
    
    @Autowired
    AdminUserMapper adminUserMapper;
    @Override
    public Result login(LoginUserVo userVo) {
        String username = userVo.getUsername();
        String password = userVo.getPassword();
        if (username == null
                || ("").equals(username)
                || password == null
                || ("").equals(password)) {
            return Result.failed("用户名或密码不能为空");
        }
        AdminUser adminUser = adminUserMapper.getUserByUsername(username);
        if (adminUser == null) {
            return Result.failed("用户不存在");
        }
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        if (adminUser.getLoginPassword().equals(passwordMd5)) {
            StpUtil.login(adminUser.getAdminUserId());
        }
        return Result.ok(adminUser,"登录成功");
    }
    
    @Override
    @Transactional
    public Result updatePassword(Integer loginUserId, String oldPassword, String newPassword) {
        if (!StringUtils.hasText(oldPassword) || !StringUtils.hasText(newPassword)) {
            return Result.failed("参数不能为空");
        }
        if (oldPassword.equals(newPassword)) {
            return Result.failed("新旧密码不能相同");
        }
        oldPassword = MD5Util.MD5Encode(oldPassword,"UTF-8");
        newPassword = MD5Util.MD5Encode(newPassword,"UTF-8");
        int updateCnt = adminUserMapper.updatePassword(loginUserId, oldPassword, newPassword);
        if (updateCnt == 0) {
            return Result.failed("旧密码错误");
        }
        return Result.ok("修改成功");
    }
    
    @Override
    public Result updateNickName(Integer loginUserId, String nickname) {
        if (nickname == null || ("").equals(nickname)) {
            return Result.failed("昵称不能为空");
        }
        int updateCnt = adminUserMapper.updateNickName(loginUserId,nickname);
        if (updateCnt == 0) {
            return Result.failed("修改失败");
        }
        return Result.ok("修改成功");
    }
}
