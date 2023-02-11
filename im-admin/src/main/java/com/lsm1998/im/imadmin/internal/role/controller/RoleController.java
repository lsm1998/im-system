package com.lsm1998.im.imadmin.internal.role.controller;

import com.lsm1998.im.common.AjaxResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController
{
    @GetMapping("/role/scan")
    public AjaxResponse scanRole()
    {
        return null;
    }
}
