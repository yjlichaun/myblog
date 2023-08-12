package com.muyi.blog.my.core.controller.admin;

import com.muyi.blog.my.core.service.ConfigService;
import com.muyi.blog.my.core.util.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//TODO:接口没测，暂时不知道干嘛的

/**
 * @author 历川
 * @version 1.0
 * @description 配置controller
 * @date 2023/8/12 14:50
 */
@RestController
@RequestMapping("/admin")
public class ConfigurationController {
    
    @Resource
    private ConfigService configService;
    
    /**
     * 更改配置文件
     */
    @PutMapping("configurations/website")
    public Result website(@RequestParam(value = "websiteName", required = false) String websiteName,
                          @RequestParam(value = "websiteDescription", required = false) String websiteDescription,
                          @RequestParam(value = "websiteLogo", required = false) String websiteLogo,
                          @RequestParam(value = "websiteIcon", required = false) String websiteIcon) {
        int updateResult = 0;
        if (StringUtils.hasText(websiteName)) {
            updateResult += configService.updateConfig("websiteName", websiteName);
        }
        if (StringUtils.hasText(websiteDescription)) {
            updateResult += configService.updateConfig("websiteDescription", websiteDescription);
        }
        if (StringUtils.hasText(websiteLogo)) {
            updateResult += configService.updateConfig("websiteLogo", websiteLogo);
        }
        if (StringUtils.hasText(websiteIcon)) {
            updateResult += configService.updateConfig("websiteIcon", websiteIcon);
        }
        return updateResult > 0 ? Result.ok("配置成功") : Result.failed("配置失败");
    }
    
    @PostMapping("/configurations/userInfo")
    public Result userInfo(@RequestParam(value = "yourAvatar", required = false) String yourAvatar,
                           @RequestParam(value = "yourName", required = false) String yourName,
                           @RequestParam(value = "yourEmail", required = false) String yourEmail) {
        int updateResult = 0;
        if (StringUtils.hasText(yourAvatar)) {
            updateResult += configService.updateConfig("yourAvatar", yourAvatar);
        }
        if (StringUtils.hasText(yourName)) {
            updateResult += configService.updateConfig("yourName", yourName);
        }
        if (StringUtils.hasText(yourEmail)) {
            updateResult += configService.updateConfig("yourEmail", yourEmail);
        }
        return updateResult > 0 ? Result.ok("配置成功") : Result.failed("配置失败");
    }
    
    @PostMapping("/configurations/footer")
    public Result footer(@RequestParam(value = "footerAbout", required = false) String footerAbout,
                         @RequestParam(value = "footerICP", required = false) String footerICP,
                         @RequestParam(value = "footerCopyRight", required = false) String footerCopyRight,
                         @RequestParam(value = "footerPoweredBy", required = false) String footerPoweredBy,
                         @RequestParam(value = "footerPoweredByURL", required = false) String footerPoweredByURL) {
        int updateResult = 0;
        if (StringUtils.hasText(footerAbout)) {
            updateResult += configService.updateConfig("footerAbout", footerAbout);
        }
        if (StringUtils.hasText(footerICP)) {
            updateResult += configService.updateConfig("footerICP", footerICP);
        }
        if (StringUtils.hasText(footerCopyRight)) {
            updateResult += configService.updateConfig("footerCopyRight", footerCopyRight);
        }
        if (StringUtils.hasText(footerPoweredBy)) {
            updateResult += configService.updateConfig("footerPoweredBy", footerPoweredBy);
        }
        if (StringUtils.hasText(footerPoweredByURL)) {
            updateResult += configService.updateConfig("footerPoweredByURL", footerPoweredByURL);
        }
        return updateResult > 0 ? Result.ok("配置成功") : Result.failed("配置失败");
    }
}
