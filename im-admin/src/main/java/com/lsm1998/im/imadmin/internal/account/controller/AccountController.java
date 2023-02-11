package com.lsm1998.im.imadmin.internal.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.middleware.interceptor.ContextHolder;
import com.lsm1998.im.imadmin.internal.account.dto.request.AccountCreateRequest;
import com.lsm1998.im.imadmin.internal.account.dto.request.LoginOutRequest;
import com.lsm1998.im.imadmin.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.imadmin.internal.account.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.lsm1998.im.common.annotations.AccessPermission;

/**
 * 账户服务
 */
@RestController
@RequestMapping("account")
public class AccountController
{
    @Resource
    private AccountService accountService;

    @Resource
    private ContextHolder contextHolder;

    /**
     * 登录
     *
     * @param request LoginRequest
     * @return AjaxResponse
     */
    @PostMapping("login")
    public AjaxResponse login(@RequestBody LoginRequest request)
    {
        request.setLoginIp(contextHolder.getRemoteIp());
        return AjaxResponse.success(accountService.login(request));
    }

    /**
     * 退出登录
     *
     * @return AjaxResponse
     */
    @PostMapping("loginOut")
    public AjaxResponse loginOut()
    {
        LoginOutRequest request = new LoginOutRequest();
        request.setToken("");
        accountService.loginOut(request);
        return AjaxResponse.success();
    }

    /**
     * 个人信息
     *
     * @return AjaxResponse
     */
    @GetMapping("profile")
    @AccessPermission("account:profile")
    public AjaxResponse profile()
    {
        return AjaxResponse.success(accountService.getAccount(""));
    }

    /**
     * 创建账户
     *
     * @param request AccountCreateRequest
     * @return AjaxResponse
     */
    @PostMapping("create")
    @AccessPermission("account:create")
    public AjaxResponse create(@RequestBody AccountCreateRequest request)
    {
        return AjaxResponse.success(accountService.create(request));
    }
}
