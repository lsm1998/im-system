package com.lsm1998.im.imadmin.internal.accessToken.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenCreateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenUpdateReq;
import com.lsm1998.im.imadmin.internal.accessToken.service.AccessTokenService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 访问凭证服务
 */
@RestController
@RequestMapping("accessToken")
public class AccessTokenController
{
    @Resource
    private AccessTokenService accessTokenService;

    /**
     * 创建访问凭证
     *
     * @param request
     * @return
     */
    @PostMapping
    public AjaxResponse create(@RequestBody @Valid AccessTokenCreateReq request)
    {
        return null;
    }

    /**
     * 更新访问凭证
     *
     * @param request
     * @return
     */
    @PutMapping
    public AjaxResponse update(@RequestBody @Valid AccessTokenUpdateReq request)
    {
        return null;
    }
}
