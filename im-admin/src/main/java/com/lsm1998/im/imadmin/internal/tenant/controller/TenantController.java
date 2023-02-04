package com.lsm1998.im.imadmin.internal.tenant.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.internal.tenant.model.request.RegisterRequest;
import com.lsm1998.im.imadmin.internal.tenant.service.TenantService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenant")
public class TenantController
{
    @Resource
    private TenantService tenantService;

    @PostMapping("register")
    public AjaxResponse register(@RequestBody RegisterRequest request)
    {
        return AjaxResponse.success(tenantService.generateAppid(request.getAppid()));
    }
}
