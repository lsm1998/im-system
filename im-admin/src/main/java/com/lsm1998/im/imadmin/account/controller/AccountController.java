package com.lsm1998.im.imadmin.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imadmin.account.model.request.LoginRequest;
import com.lsm1998.im.imadmin.account.model.response.LoginResponse;
import com.lsm1998.im.imadmin.account.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AccountController
{
    @Resource
    private AccountService accountService;

    @PostMapping("login")
    public AjaxResponse login(HttpServletRequest request, @RequestBody LoginRequest loginData)
    {
        loginData.setLoginIp(request.getRemoteHost());
        return AjaxResponse.success(accountService.login(loginData));
    }
}
