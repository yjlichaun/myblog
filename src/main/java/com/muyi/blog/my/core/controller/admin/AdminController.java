package com.muyi.blog.my.core.controller.admin;
import cn.dev33.satoken.stp.StpUtil;
import com.muyi.blog.my.core.service.*;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.LoginUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 历川
 * @version 1.0
 * @description 后台管理接口
 * @date 2023/8/10 10:14
 */
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    AdminUserService adminUserService;
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    BlogService blogService;
    
    @Autowired
    LinkService linkService;
    
    @Autowired
    TagService tagService;
    
    @Autowired
    CommentService commentService;
    
    /**
     * 登录跳转后台，需要向后台发起登录请求，浏览器默认只能发送get请求，需要转换为post请求
     *
     * @return 请求url
     */
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }
    
    /**
     * 默认页面渲染
     *
     * @param request 请求体
     * @return 请求url
     */
    @GetMapping({"", "/", "/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        request.setAttribute("categoryCount", categoryService.getTotalCategories().getData());
        request.setAttribute("blogCount", blogService.getTotalBlogs().getData());
        request.setAttribute("linkCount", linkService.getTotalLinks().getData());
        request.setAttribute("tagCount", tagService.getTotalTags().getData());
        request.setAttribute("commentCount", commentService.getTotalComments().getData());
        return "admin/index";
    }
    
    
    //TODO :测试环境，直接传入验证码参数
    /**
     * 登录接口
     *
     * @param userVo 登录用户信息
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginUserVo userVo, @RequestParam("verifyCode") String verifyCode) {
        if (verifyCode == null
                || userVo.getVerifyCode() == null
                || !verifyCode.equals(userVo.getVerifyCode())
                || ("").equals(userVo.getVerifyCode())) {
            return Result.failed("验证码错误");
        }
        return adminUserService.login(userVo);
    }
    
    
    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return Result
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword) {
        int loginUserId = StpUtil.getLoginIdAsInt();
        return adminUserService.updatePassword(loginUserId, oldPassword, newPassword);
    }
    
    
    /**
     * 修改昵称
     * @param nickname 昵称
     * @return result
     */
    @PutMapping("/updateNickname")
    public Result updateNickName(@RequestParam("nickName") String nickname) {
        int loginUserId = StpUtil.getLoginIdAsInt();
        return adminUserService.updateNickName(loginUserId,nickname);
    }
    
    /**
     * 登出
     * @return Result
     */
    @PostMapping("/logout")
    public Result logout() {
        int loginUserId = StpUtil.getLoginIdAsInt();
        StpUtil.logout(loginUserId);
        return Result.ok("登出成功！！！");
    }
}
