package com.muyi.blog.my.core.service.impl;


import com.muyi.blog.my.core.entity.Blog;
import com.muyi.blog.my.core.entity.BlogCategory;
import com.muyi.blog.my.core.entity.BlogTag;
import com.muyi.blog.my.core.entity.BlogTagRelation;
import com.muyi.blog.my.core.mapper.BlogCategoryMapper;
import com.muyi.blog.my.core.mapper.BlogMapper;
import com.muyi.blog.my.core.mapper.BlogTagMapper;
import com.muyi.blog.my.core.mapper.BlogTagRelationMapper;
import com.muyi.blog.my.core.service.BlogService;
import com.muyi.blog.my.core.util.PageQueryUtil;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.BlogVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客接口实现类
 * @date 2023/8/10 11:03
 */
@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
    
    
    @Autowired
    BlogMapper blogMapper;
    
    @Autowired
    BlogCategoryMapper categoryMapper;
    
    @Autowired
    BlogTagMapper tagMapper;
    
    @Autowired
    BlogTagRelationMapper blogTagRelationMapper;
    
    @Override
    public Result getTotalBlogs() {
        return Result.ok(blogMapper.getTotalBlogs(null));
    }
    
    @Override
    public Result getBlogPage(Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return Result.failed("参数异常");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<Blog> blogs = blogMapper.findBlogList(pageUtil);
        int total = blogMapper.getTotalBlogs(pageUtil);
        PageResult pageResult = new PageResult(blogs, total, pageUtil.getLimit(), pageUtil.getPage());
        return Result.ok(pageResult, "查询成功！！！");
    }
    
    @Override
    @Transactional
    public Result editBlogCategory(Long blogId, BlogCategory blogCategory) {
        Blog blog = blogMapper.getBlogById(blogId);
        if (blog == null) {
            return Result.failed("该博客不存在！！！");
        }
        if (blogCategory == null) {
            return Result.failed("类别不能为空");
        }
        blog.setBlogCategoryId(blogCategory.getCategoryId());
        blog.setBlogCategoryName(blogCategory.getCategoryName());
        blog.setUpdateTime(new Date());
        int updateCnt = blogMapper.updateBlog(blog);
        if (updateCnt == 0) {
            return Result.failed("修改失败！！！");
        }
        return Result.ok("编辑成功");
    }
    
    @Override
    @Transactional
    public Result save(BlogVo blogVo) {
        if (!StringUtils.hasText(blogVo.getBlogTitle())) {
            return Result.failed("请输入文章标题");
        }
        if (blogVo.getBlogTitle().trim().length() > 150) {
            return Result.failed("标题过长");
        }
        if (!StringUtils.hasText(blogVo.getBlogTags())) {
            return Result.failed("请输入标签");
        }
        if (blogVo.getBlogTags().trim().length() > 150) {
            return Result.failed("标签过长");
        }
        if (blogVo.getBlogSubUrl().trim().length() > 150) {
            return Result.failed("路径过长");
        }
        if (StringUtils.hasText(blogVo.getBlogContent())) {
            return Result.failed("请输入文章内容");
        }
        if (blogVo.getBlogContent().trim().length() > 100000) {
            return Result.failed("文章内容过长");
        }
        if (!StringUtils.hasText(blogVo.getBlogCoverImage())) {
            return Result.failed("封面不能为空");
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogVo, blog);
        blog.setCreateTime(new Date());
        blog.setIsDeleted((byte) 1);
        BlogCategory blogCategory = categoryMapper.selectByPrimaryKey(blog.getBlogCategoryId());
        if (blogCategory == null){
            blog.setBlogCategoryId(0);
            blog.setBlogCategoryName("默认分类");
        }else{
            //设置博客分类名称
            blog.setBlogCategoryName(blogCategory.getCategoryName());
            //分类的排序值加1
            blogCategory.setCategoryRank(blogCategory.getCategoryRank() + 1);
        }
        //处理标签数据
        String[] tags = blog.getBlogTags().split(",");
        if (tags.length > 6) {
            return Result.failed("标签的数量限制为6");
        }
        //保存文章
        if (blogMapper.insertSelective(blog) > 0) {
            //新增的tag对象
            List<BlogTag> tagListForInsert = new ArrayList<BlogTag>();
            //所有的tag对象，用于建立关系数据
            List<BlogTag> allTagsList = new ArrayList<>();
            for (int i = 0; i < tags.length; i++) {
                BlogTag tag = tagMapper.selectByTagName(tags[i]);
                if (tag == null) {
                    //不存在就新增
                    BlogTag tempTag = new BlogTag();
                    tempTag.setTagName(tags[i]);
                    tagListForInsert.add(tempTag);
                }else {
                    allTagsList.add(tag);
                }
            }
            //新增标签数据并修改分类排序值
            if (!CollectionUtils.isEmpty(tagListForInsert)) {
                tagMapper.batchInsertBlogTag(tagListForInsert);
            }
            if (blogCategory != null) {
                categoryMapper.updateByPrimaryKeySelective(blogCategory);
            }
            List<BlogTagRelation> blogTagRelations = new ArrayList<>();
            //新增关系数据
            allTagsList.addAll(tagListForInsert);
            for (BlogTag tag : allTagsList) {
                BlogTagRelation blogTagRelation = new BlogTagRelation();
                blogTagRelation.setBlogId(blog.getBlogId());
                blogTagRelation.setTagId(tag.getTagId());
                blogTagRelations.add(blogTagRelation);
            }
            if (blogTagRelationMapper.batchInsert(blogTagRelations) > 0) {
                return Result.ok("保存成功");
            }
        }
        return Result.failed("保存失败");
        
    }
}
