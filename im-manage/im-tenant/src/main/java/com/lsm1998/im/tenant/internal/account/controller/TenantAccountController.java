package com.lsm1998.im.tenant.internal.account.controller;

import com.lsm1998.im.tenant.internal.account.service.TenantAccountService;
import com.lsm1998.im.tenant.middleware.interceptor.ContextHolder;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class TenantAccountController
{
    @Resource
    private ContextHolder contextHolder;

    @Resource
    private TenantAccountService userService;


}
