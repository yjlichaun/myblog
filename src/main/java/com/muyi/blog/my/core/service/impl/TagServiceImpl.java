package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.entity.BlogTag;
import com.muyi.blog.my.core.mapper.BlogTagMapper;
import com.muyi.blog.my.core.mapper.BlogTagRelationMapper;
import com.muyi.blog.my.core.service.TagService;
import com.muyi.blog.my.core.util.PageQueryUtil;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 博客标签接口实现类
 * @date 2023/8/10 11:27
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {
    
    
    @Autowired
    BlogTagMapper blogTagMapper;
    
    @Autowired
    BlogTagRelationMapper relationMapper;
    @Override
    public Result getTotalTags() {
        return Result.ok(blogTagMapper.getTotalTags(null));
    }
    
    @Override
    public Result getTagList(Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return Result.failed("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<BlogTag> tagList = blogTagMapper.getTagList(pageUtil);
        int total = blogTagMapper.getTotalTags(pageUtil);
        PageResult pageResult = new PageResult(tagList,total,pageUtil.getLimit(),pageUtil.getPage());
        return Result.ok(pageResult,"查询成功");
    }
    
    @Override
    @Transactional
    public Result saveTag(String tagName) {
        if (!StringUtils.hasText(tagName)){
            return Result.failed("参数异常!!!");
        }
        BlogTag tagTmp = blogTagMapper.selectByTagName(tagName);
        if (tagTmp != null) {
            return Result.failed("标签已经存在");
        }
        BlogTag tag = new BlogTag();
        tag.setTagName(tagName);
        if (blogTagMapper.insertTag(tag) > 0) {
            return Result.ok("添加成功!!!");
        }
        return Result.failed("添加失败");
    }
    
    @Override
    @Transactional
    public Result deleteTagByIds(Integer[] ids) {
        if (ids == null || ids.length < 1 ) {
            return Result.failed("参数异常");
        }
        List<Long> relations = relationMapper.selectDistinctTagIds(ids);
        if (!CollectionUtils.isEmpty(relations)) {
            return Result.failed("已经存在关联数据无法强制删除");
        }
        if (blogTagMapper.deleteTagByIds(ids) > 0) {
            return Result.ok("删除成功!!!");
        }
        return Result.failed("删除失败");
    }
}

