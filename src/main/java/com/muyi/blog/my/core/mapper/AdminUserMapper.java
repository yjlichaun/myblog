package com.muyi.blog.my.core.mapper;

import com.muyi.blog.my.core.entity.AdminUser;
import org.apache.ibatis.annotations.*;

/**
 * @author 历川
 * @version 1.0
 * @description 后台用户mapper
 * @date 2023/8/10 11:32
 */
@Mapper
public interface AdminUserMapper {
    
    /**
     * 根据用户名获取数据
     *
     * @param username 用户名
     * @return 用户
     */
    @ResultMap("BaseResultMap")
    @Select("select * from tb_admin_user where login_user_name = #{username}")
    AdminUser getUserByUsername(@Param("username") String username);
    
    /**
     * 修改用户密码
     *
     * @param loginUserId 用户id
     * @param oldPassword 用户旧密码
     * @param newPassword 用户新密码
     * @return int
     */
    @Update("update tb_admin_user set login_password = #{newPassword}" +
            " where admin_user_id = #{loginUserId} and login_password = #{oldPassword}")
    int updatePassword(@Param("loginUserId") Integer loginUserId,
                       @Param("oldPassword") String oldPassword,
                       @Param("newPassword") String newPassword);
    
    /**
     * 修改昵称
     *
     * @param loginUserId 用户id
     * @param nickname    昵称
     * @return Result
     */
    @Update("update tb_admin_user set nick_name = #{nickname}" +
            " where admin_user_id = #{loginUserId}")
    int updateNickName(@Param("loginUserId") Integer loginUserId,
                       @Param("nickname") String nickname);
}
