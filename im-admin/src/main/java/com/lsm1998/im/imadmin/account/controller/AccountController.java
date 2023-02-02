package com.lsm1998.im.imadmin.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.account.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController
{
    @Resource
    private AccountService accountService;

    @PostMapping("login")
    public AjaxResponse login()
    {

        return AjaxResponse.success();
    }
}
