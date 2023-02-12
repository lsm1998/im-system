package com.lsm1998.im.imadmin.internal.accessToken.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenCreateReq;
import com.lsm1998.im.imadmin.internal.accessToken.dto.request.AccessTokenListReq;
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
     * @param request AccessTokenCreateReq
     * @return AjaxResponse
     */
    @PostMapping
    @AccessPermission("accessToken:create")
    public AjaxResponse create(@RequestBody @Valid AccessTokenCreateReq request)
    {
        return AjaxResponse.success(accessTokenService.saveAccessToken(request));
    }

    /**
     * 更新访问凭证
     *
     * @param request AccessTokenUpdateReq
     * @return AjaxResponse
     */
    @PutMapping
    @AccessPermission("accessToken:update")
    public AjaxResponse update(@RequestBody @Valid AccessTokenUpdateReq request)
    {
        return AjaxResponse.success(accessTokenService.updateAccessToken(request));
    }

    /**
     * 删除访问凭证
     *
     * @param id
     * @return AjaxResponse
     */
    @DeleteMapping("/{id}")
    @AccessPermission("accessToken:delete")
    public AjaxResponse delete(@PathVariable Long id)
    {
        return AjaxResponse.success(accessTokenService.deleteAccessToken(id));
    }

    /**
     * 查询列表
     *
     * @param request AccessTokenListReq
     * @return AjaxResponse
     */
    @GetMapping
    @AccessPermission("accessToken:list")
    public AjaxResponse list(AccessTokenListReq request)
    {
        return AjaxResponse.success(accessTokenService.list(request));
    }
}
