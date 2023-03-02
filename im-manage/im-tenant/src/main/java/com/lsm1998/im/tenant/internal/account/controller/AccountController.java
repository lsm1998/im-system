package com.lsm1998.im.tenant.internal.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.tenant.internal.account.service.AccountService;
import com.lsm1998.im.tenant.middleware.interceptor.ContextHolder;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController
{
    @Resource
    private ContextHolder contextHolder;

    @Resource
    private AccountService userService;

    @GetMapping("/profile")
    public AjaxResponse profile()
    {
        return AjaxResponse.success(userService.profile(contextHolder.getUserId()));
    }
}
