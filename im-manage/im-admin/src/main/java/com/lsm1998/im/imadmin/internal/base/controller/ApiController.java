package com.lsm1998.im.imadmin.internal.base.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.internal.base.dto.response.LoginInfoResponse;
import com.lsm1998.im.imadmin.internal.base.dto.response.SiteInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api首页服务
 */
@RequestMapping("base/api")
@RestController
public class ApiController
{
    /**
     * 站点配置
     *
     * @return AjaxResponse
     */
    @GetMapping("siteInfo")
    public AjaxResponse siteInfo()
    {
        SiteInfoResponse.Upload upload = new SiteInfoResponse.Upload(10485760, "/storage/{topic}/{year}{mon}{day}/{filesha1}{.suffix}", "jpg,png,bmp,jpeg,gif,webp,zip,rar,xls,xlsx,doc,docx,wav,mp4,mp3,txt", "local");
        SiteInfoResponse.SiteInfo siteInfo = new SiteInfoResponse.SiteInfo("BuildAdmin", "渝ICP备2020013067号-2", "v1.0.0", "https://demo.buildadmin.com", upload, true);
        return AjaxResponse.success(new SiteInfoResponse(siteInfo));
    }

    /**
     * 登录配置
     *
     * @return AjaxResponse
     */
    @GetMapping("loginInfo")
    public AjaxResponse loginInfo()
    {
        LoginInfoResponse response = new LoginInfoResponse();
        response.setCaptcha(true);
        return AjaxResponse.success(response);
    }
}
