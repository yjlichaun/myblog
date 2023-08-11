package com.muyi.blog.my.core.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.mapper.BlogCategoryMapper;
import com.muyi.blog.my.core.mapper.BlogMapper;
import com.muyi.blog.my.core.service.CategoryService;
import com.muyi.blog.my.core.util.PageQueryUtil;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.CategoryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客类型接口实现类
 * @date 2023/8/10 10:51
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    BlogCategoryMapper blogCategoryMapper;
    
    @Autowired
    BlogMapper blogMapper;
    @Override
    public Result getTotalCategories() {
        return Result.ok(blogCategoryMapper.getTotalCategories(null));
    }
    
    @Override
    public Result getAllCategories() {
        List<BlogCategory> list =  blogCategoryMapper.getAllCategories(null);
        return Result.ok(list,"查询成功！！！");
    }
    
    @Override
    public Result getBlogCategoryList(Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return Result.failed("参数异常!!!");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<BlogCategory> categoryList = blogCategoryMapper.getAllCategories(pageUtil);
        int total = blogCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList,total,pageUtil.getLimit(),pageUtil.getPage());
        return Result.ok(pageResult,"查询成功！！！");
    }
    
    @Override
    @Transactional
    public Result saveCategory(CategoryVo categoryVo) {
        String categoryName = categoryVo.getCategoryName();
        String categoryIcon = categoryVo.getCategoryIcon();
        if (!StringUtils.hasText(categoryName)){
            return Result.failed("请输入分类名称");
        }
        if (!StringUtils.hasText(categoryIcon)) {
            return Result.failed("请输入分类图标");
        }
        BlogCategory categoryTmp = blogCategoryMapper.getCategoryByName(categoryName);
        if (categoryTmp != null){
            return Result.failed("该分类已经存在");
        }
        BlogCategory category = new BlogCategory();
        BeanUtils.copyProperties(categoryVo,category);
        if (blogCategoryMapper.insertCategory(category) > 0){
            return Result.ok("添加完成！！！");
        }
        return Result.failed("添加失败！！！");
    }
    
    @Override
    @Transactional
    public Result updateCategory(BlogCategory category) {
        String categoryName = category.getCategoryName();
        String categoryIcon = category.getCategoryIcon();
        if (!StringUtils.hasText(categoryName)) {
            return Result.failed("博客种类名称不能为空");
        }
        if (!StringUtils.hasText(categoryIcon)) {
            return Result.failed("博客种类图标不能为空");
        }
        if (blogCategoryMapper.updateByPrimaryKeySelective(category) > 0) {
            blogMapper.updateBlogCategorys(categoryName,category.getCategoryId(),new Integer[]{category.getCategoryId()});
            return Result.ok("更新成功");
        }
        return Result.failed("更新失败");
    }
    
    @Override
    @Transactional
    public Result deleteCategories(Integer[] ids) {
        if (ids == null || ids.length < 1) {
            return Result.failed("至少需要一个参数");
        }
        if (blogCategoryMapper.deleteCategories(ids) > 0){
            blogMapper.updateBlogCategorys("默认分类",0,ids);
            return Result.ok("删除成功！！！");
        }
        return Result.failed("删除失败，分类不存在");
    }
}
