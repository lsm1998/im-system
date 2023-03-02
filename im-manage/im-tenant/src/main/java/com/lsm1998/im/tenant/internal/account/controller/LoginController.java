package com.lsm1998.im.tenant.internal.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.tenant.internal.account.dto.request.LoginRequest;
import com.lsm1998.im.tenant.internal.account.service.TenantAccountService;
import com.lsm1998.im.tenant.middleware.interceptor.ContextHolder;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class LoginController
{
    @Resource
    private ContextHolder contextHolder;

    @Resource
    private TenantAccountService userService;

    @PostMapping("/login")
    public AjaxResponse login(@RequestBody LoginRequest request)
    {
        request.setRemoteIp(contextHolder.getRemoteIp());
        return AjaxResponse.success(userService.login(request));
    }
}
