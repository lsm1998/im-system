package com.lsm1998.im.tenant.internal.user.controller;

import com.lsm1998.im.common.AjaxResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController
{
    @PostMapping("/login")
    public AjaxResponse login()
    {

        return AjaxResponse.success();
    }
}
