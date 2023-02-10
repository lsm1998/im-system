package com.lsm1998.im.imadmin.internal.account.controller;

import com.lsm1998.im.common.AjaxResponse;
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

    /**
     * 登录
     * @param request
     * @return
     */
    @PostMapping("login")
    public AjaxResponse login( @RequestBody LoginRequest request)
    {
        // todo
        // request.setLoginIp(request.getRemoteHost());
        return AjaxResponse.success(accountService.login(request));
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("loginOut")
    @AccessPermission(url = "/account/loginOut")
    public AjaxResponse loginOut()
    {
        LoginOutRequest request = new LoginOutRequest();
        request.setToken("");
        accountService.loginOut(request);
        return AjaxResponse.success();
    }

    /**
     * 个人信息
     * @return
     */
    @GetMapping("profile")
    @AccessPermission(url = "/account/profile")
    public AjaxResponse profile()
    {
        return AjaxResponse.success(accountService.getAccount(""));
    }

    /**
     * 创建账户
     * @param request
     * @return
     */
    @PostMapping("create")
    @AccessPermission(url = "/account/create")
    public AjaxResponse create(@RequestBody AccountCreateRequest request)
    {
        return AjaxResponse.success(accountService.create(request));
    }
}
