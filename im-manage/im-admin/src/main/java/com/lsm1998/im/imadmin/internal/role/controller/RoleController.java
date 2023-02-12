package com.lsm1998.im.imadmin.internal.role.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.imadmin.internal.role.sevice.RoleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限服务
 */
@RestController
@RequestMapping("role")
public class RoleController
{
    @Resource
    private RoleService roleService;

    /**
     * 扫描所有权限
     *
     * @return AjaxResponse
     */
    @GetMapping("/authorityAll")
    // @AccessPermission("role:scan")
    public AjaxResponse scanRole()
    {
        return AjaxResponse.success(roleService.authorityAll());
    }
}
