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
    //{
    //
    //    "data":{
    //        "menus":[
    //            {
    //                "id":2,
    //                "pid":0,
    //                "type":"menu_dir",
    //                "title":"我的账户",
    //                "name":"account",
    //                "path":"account",
    //                "icon":"fa fa-user-circle",
    //                "menu_type":"tab",
    //                "url":"",
    //                "component":"",
    //                "extend":"none",
    //                "children":[
    //                    {
    //                        "id":3,
    //                        "pid":2,
    //                        "type":"menu",
    //                        "title":"账户概览",
    //                        "name":"account\/overview",
    //                        "path":"account\/overview",
    //                        "icon":"fa fa-home",
    //                        "menu_type":"tab",
    //                        "url":"",
    //                        "component":"\/src\/views\/frontend\/user\/account\/overview.vue",
    //                        "extend":"none"
    //                    },
    //                    {
    //                        "id":4,
    //                        "pid":2,
    //                        "type":"menu",
    //                        "title":"个人资料",
    //                        "name":"account\/profile",
    //                        "path":"account\/profile",
    //                        "icon":"fa fa-user-circle-o",
    //                        "menu_type":"tab",
    //                        "url":"",
    //                        "component":"\/src\/views\/frontend\/user\/account\/profile.vue",
    //                        "extend":"none"
    //                    },
    //                    {
    //                        "id":5,
    //                        "pid":2,
    //                        "type":"menu",
    //                        "title":"修改密码",
    //                        "name":"account\/changePassword",
    //                        "path":"account\/changePassword",
    //                        "icon":"fa fa-shield",
    //                        "menu_type":"tab",
    //                        "url":"",
    //                        "component":"\/src\/views\/frontend\/user\/account\/changePassword.vue",
    //                        "extend":"none"
    //                    },
    //                    {
    //                        "id":6,
    //                        "pid":2,
    //                        "type":"menu",
    //                        "title":"积分记录",
    //                        "name":"account\/integral",
    //                        "path":"account\/integral",
    //                        "icon":"fa fa-tag",
    //                        "menu_type":"tab",
    //                        "url":"",
    //                        "component":"\/src\/views\/frontend\/user\/account\/integral.vue",
    //                        "extend":"none"
    //                    },
    //                    {
    //                        "id":7,
    //                        "pid":2,
    //                        "type":"menu",
    //                        "title":"余额记录",
    //                        "name":"account\/balance",
    //                        "path":"account\/balance",
    //                        "icon":"fa fa-money",
    //                        "menu_type":"tab",
    //                        "url":"",
    //                        "component":"\/src\/views\/frontend\/user\/account\/balance.vue",
    //                        "extend":"none"
    //                    }
    //                ]
    //            }
    //        ]
    //    }
    //}

    @Resource
    private MenuService menuService;

    @GetMapping("/menu")
    @AccessPermission
    public AjaxResponse getMenu()
    {
        return AjaxResponse.success(menuService.menuTreeList());
    }
}
