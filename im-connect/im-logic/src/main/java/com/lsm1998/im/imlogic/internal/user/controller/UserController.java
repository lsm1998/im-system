package com.lsm1998.im.imlogic.internal.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.imlogic.internal.user.dto.request.CreateAccessTokenRequest;
import com.lsm1998.im.imlogic.internal.user.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Resource
    private UserService userService;

    @RequestMapping("/createAccessToken")
    public AjaxResponse createAccessToken(HttpServletRequest request) throws Exception
    {
        byte[] bytes = request.getInputStream().readAllBytes();
        ObjectMapper mapper = new ObjectMapper();
        CreateAccessTokenRequest tokenRequest = mapper.readValue(bytes, CreateAccessTokenRequest.class);
        tokenRequest.setBody(bytes);
        return AjaxResponse.success(userService.createAccessToken(tokenRequest));
    }
}
