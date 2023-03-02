package com.lsm1998.im.tenant.internal.account.controller;

import com.lsm1998.im.tenant.internal.account.service.PacketService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class PacketController
{
    @Resource
    private PacketService packetService;
}
