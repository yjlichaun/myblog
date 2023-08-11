package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.service.CategoryService;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客分类controller
 * @date 2023/8/11 10:41
 */
@RestController
@RequestMapping("/admin")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    
    /**
     * 分类列表
     */
    @GetMapping("category/list")
    public Result list(@RequestBody Map<String, Object> params) {
        return categoryService.getBlogCategoryList(params);
    }
    
    
    /**
     * 添加博客种类
     * @param categoryVo 博客种类vo对象
     * @return Result
     */
    @PostMapping("/category/save")
    public Result save(@RequestBody CategoryVo categoryVo) {
        return categoryService.saveCategory(categoryVo);
    }
    
    
    /**
     * 修改博客种类
     * @param category 博客种类对象
     * @return Result
     */
    @PutMapping("category/update")
    public Result update(@RequestBody BlogCategory category) {
        return categoryService.updateCategory(category);
    }
    
    
    /**
     * 根据id列表删除对应分类
     * @param ids id列表
     * @return  Result
     */
    @DeleteMapping("/category/delete")
    public Result delete(@RequestBody Integer[] ids) {
        return categoryService.deleteCategories(ids);
    }
}
