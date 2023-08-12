package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.service.TagService;
import com.muyi.blog.my.core.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author 历川
 * @version 1.0
 * @description 标签controller
 * @date 2023/8/12 16:22
 */
@RestController
@RequestMapping("/admin")
public class TagController {
    
    @Autowired
    TagService tagService;
    
    
    /**
     * 获取标签列表
     * @param params 分页参数
     * @return result
     */
    @GetMapping("/tags/list")
    public Result list(@RequestBody Map<String,Object> params) {
        return tagService.getTagList(params);
    }
    
    /**
     * 添加标签
     * @param tagName 标签名称
     * @return result
     */
    @PostMapping("/tags/save")
    public Result save(@RequestParam("tagName") String tagName){
        return tagService.saveTag(tagName);
    }
    
    
    /**
     * 删除标签
     * @param ids 标签id列表
     * @return result
     */
    @DeleteMapping("/tags/delete")
    public Result delete(@RequestBody Integer[] ids){
        return tagService.deleteTagByIds(ids);
    }
}
