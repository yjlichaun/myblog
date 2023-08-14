package com.muyi.blog.my.core.controller.blog;

import com.muyi.blog.my.core.service.BlogService;
import com.muyi.blog.my.core.service.ConfigService;
import com.muyi.blog.my.core.service.TagService;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 历川
 * @version 1.0
 * @description 博客controller
 * @date 2023/8/12 16:56
 */
@RestController
@RequestMapping("/blog")
public class MyBlogController {
    
    //public static String theme = "default";
    //public static String theme = "yummy-jekyll";
    
    
    @Autowired
    BlogService blogService;
    
    @Autowired
    TagService tagService;
    
    @Autowired
    ConfigService configService;
    /**
     * 当前模板
     */
    public static String theme  = "amaze";
    
    /**
     * 首页
     */
    @GetMapping({"/", "/index", "index.html"})
    public Result index() {
        return this.page(1);
    }
    
    
    /**
     * 返回该页资源
     * @param pageNum 页码
     * @return Result
     */
    @GetMapping("/page")
    public Result page(@RequestParam("pageNum") int pageNum) {
        PageResult blogPageResult = blogService.getBlogForIndexPage(pageNum);
        if (blogPageResult == null) {
            return Result.failed("资源请求错误");
        }
        Map data = new HashMap<>();
        data.put("blogPageResult",blogPageResult);
        data.put("newBlogs",blogService.getBlogListForIndexPage(1));
        data.put("hotBlogs", blogService.getBlogListForIndexPage(0));
        data.put("hotTags", tagService.getBlogTagCountForIndex());
        data.put("pageName","首页");
        data.put("configurations", configService.getAllConfigs());
        ResourceVo resourceVo = new ResourceVo();
        resourceVo.setTheme(theme);
        resourceVo.setData(data);
        return Result.ok(resourceVo,"获取资源完成");
    }
}



