package com.lsm1998.im.tenant.internal.base.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.tenant.internal.base.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class MenuController
{
    @Resource
    private MenuService menuService;

    @GetMapping("/menu")
    @AccessPermission
    public AjaxResponse getMenu()
    {
        return AjaxResponse.success(menuService.menuTreeList());
    }
}
