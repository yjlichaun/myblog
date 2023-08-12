package com.muyi.blog.my.core.service.impl;

import com.muyi.blog.my.core.entity.BlogLink;
import com.muyi.blog.my.core.mapper.BlogLinkMapper;
import com.muyi.blog.my.core.service.LinkService;
import com.muyi.blog.my.core.util.PageQueryUtil;
import com.muyi.blog.my.core.util.PageResult;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.BlogVo;
import com.muyi.blog.my.core.vo.LinkVo;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
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
 * @description 链接接口实现类
 * @date 2023/8/10 11:19
 */
@Service
@Slf4j
public class LinkServiceImpl implements LinkService {
    
    
    @Autowired
    BlogLinkMapper blogLinkMapper;
    
    @Override
    public Result getTotalLinks() {
        return Result.ok(blogLinkMapper.getTotalLinks(null));
    }
    
    @Override
    public Result getBlogLinkList(Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return Result.failed("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        List<BlogLink> linkList = blogLinkMapper.getBlogLinkList(pageUtil);
        int total = blogLinkMapper.getTotalLinks(pageUtil);
        PageResult pageResult = new PageResult(linkList, total, pageUtil.getLimit(), pageUtil.getPage());
        return Result.ok(pageResult, "查询成功!!!");
    }
    
    @Override
    @Transactional
    public Result saveLink(LinkVo linkVo) {
        if (linkVo.getLinkType() == null
                || linkVo.getLinkType() < 0
                || linkVo.getLinkRank() == null
                || linkVo.getLinkRank() < 0
                || !StringUtils.hasText(linkVo.getLinkName())
                || !StringUtils.hasText(linkVo.getLinkName())
                || !StringUtils.hasText(linkVo.getLinkUrl())
                || !StringUtils.hasText(linkVo.getLinkDescription())) {
            return Result.failed("参数异常！");
        }
        BlogLink blogLink = new BlogLink();
        BeanUtils.copyProperties(linkVo, blogLink);
        if (blogLinkMapper.insertLink(blogLink) > 0) {
            return Result.ok("添加成功!!!");
        }
        return Result.failed("添加失败!!!");
    }
    
    @Override
    public Result getLinkInfoById(Integer id) {
        BlogLink blogLink = blogLinkMapper.getLinkInfoById(id);
        if (blogLink == null) {
            return Result.failed("该链接不存在");
        }
        return Result.ok(blogLink, "查询成功!!!");
    }
    
    @Override
    @Transactional
    public Result updateLink(BlogLink blogLink) {
        BlogLink linkTmp = blogLinkMapper.getLinkInfoById(blogLink.getLinkId());
        if (linkTmp == null) {
            return Result.failed("链接不存在");
        }
        if (blogLink.getLinkType() == null
                || blogLink.getLinkType() < 0
                || blogLink.getLinkRank() == null
                || blogLink.getLinkRank() < 0
                || !StringUtils.hasText(blogLink.getLinkName())
                || !StringUtils.hasText(blogLink.getLinkName())
                || !StringUtils.hasText(blogLink.getLinkUrl())
                || !StringUtils.hasText(blogLink.getLinkDescription())) {
            return Result.failed("参数异常！");
        }
        if (blogLinkMapper.updateLink(blogLink) > 0) {
            return Result.ok("更新友链成功!!!");
        }
        return Result.failed("更新友链失败!!!");
    }
    
    @Override
    @Transactional
    public Result deleteLinkByIds(Integer[] ids) {
        if (ids == null || ids.length < 1) {
            return Result.failed("参数异常!!!");
        }
        
        if (blogLinkMapper.deleteLink(ids) > 0) {
            return Result.ok("删除成功!!!");
        }
        return Result.failed("删除失败!!!");
    }
}