package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.entity.BlogLink;
import com.muyi.blog.my.core.service.LinkService;
import com.muyi.blog.my.core.util.Result;
import com.muyi.blog.my.core.vo.LinkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 链接controller
 * @date 2023/8/12 15:14
 */
@RestController
@RequestMapping("/admin")
public class LinkController {
    
    @Autowired
    LinkService linkService;
    
    /**
     * 获取链接列表
     * @param params 分页参数
     * @return result
     */
    @GetMapping("/links/list")
    public Result list(@RequestBody Map<String, Object> params) {
        return linkService.getBlogLinkList(params);
    }
    
    
    /**
     * 添加友链
     * @param linkVo 友链对象
     * @return Result
     */
    @PostMapping("/links/save")
    public Result save(@RequestBody LinkVo linkVo) {
        return linkService.saveLink(linkVo);
    }
    
    /**
     * 获取链接详情
     * @param id 链接id
     * @return Result
     */
    @GetMapping("/links/info/{id}")
    public Result info(@PathVariable("id") Integer id) {
        return linkService.getLinkInfoById(id);
    }
    
    
    /**
     * 修改友链
     * @param blogLink 友链对象
     * @return Result
     */
    @PutMapping("/links/update")
    public Result update(@RequestBody BlogLink blogLink){
        return linkService.updateLink(blogLink);
    }
    
    
    /**
     * 删除友链
     * @param ids 友链id列表
     * @return Result
     */
    @DeleteMapping("/links/delete")
    public Result delete(@RequestBody Integer[] ids) {
        return linkService.deleteLinkByIds(ids);
    }
}
