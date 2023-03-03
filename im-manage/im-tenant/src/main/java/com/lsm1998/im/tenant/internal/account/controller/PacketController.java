package com.lsm1998.im.tenant.internal.account.controller;

import com.lsm1998.im.common.AjaxResponse;
import com.lsm1998.im.tenant.internal.account.service.PacketService;
import com.lsm1998.im.tenant.middleware.interceptor.ContextHolder;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class PacketController
{
    @Resource
    private PacketService packetService;

    @Resource
    private ContextHolder contextHolder;

    @GetMapping("/packet")
    public AjaxResponse getPacket()
    {
        return AjaxResponse.success(packetService.getPacket(contextHolder.getAppid()));
    }
}
