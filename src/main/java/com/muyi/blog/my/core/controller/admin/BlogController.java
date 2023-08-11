package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.entity.Blog;
import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.service.BlogService;
import com.muyi.blog.my.core.service.CategoryService;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客controller
 * @date 2023/8/10 17:05
 */
@RestController
@RequestMapping("/admin")
public class BlogController {
    
    @Autowired
    BlogService blogService;
    
    @Autowired
    CategoryService categoryService;
    /**
     * 获取博客列表
     * @param params 分页参数
     * @return Result
     */
    @GetMapping("/blogs/list")
    public Result list(@RequestBody Map<String,Object> params) {
        return blogService.getBlogPage(params);
    }
    
    
    /**
     * 编辑前获取全部博客类别
     * @return Result
     */
    @GetMapping("/blog/edit")
    public Result edit(){
        return categoryService.getAllCategories();
    }
    
    /**
     * 根据博客id编辑博客
     * @param blogId
     * @return
     */
    @GetMapping("/blog/edit/{blogId}")
    public Result edit(@PathVariable Long blogId, @RequestBody BlogCategory blogCategory) {
        return blogService.editBlogCategory(blogId,blogCategory);
    }
    
    
    /**
     * 保存博客
     * @param blogVo 博客可视类
     * @return Result
     */
    @PostMapping("/blogs/save")
    public Result save(@RequestBody BlogVo blogVo){
        return blogService.save(blogVo);
    }
    
    
    /**
     * 根据博客id和删除博客
     * @param ids id列表
     * @return Result
     */
    @DeleteMapping("/blogs/delete")
    public Result delete(@RequestBody Integer[] ids){
        return blogService.deleteBlogByIds(ids);
    }
}
