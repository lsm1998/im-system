package com.lsm1998.im.tenant.internal.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lsm1998.im.tenant.internal.account.dao.Packet;
import com.lsm1998.im.tenant.internal.account.dao.mapper.PacketMapper;
import com.lsm1998.im.tenant.internal.account.service.PacketService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PacketServiceImpl implements PacketService
{
    @Resource
    private PacketMapper packetMapper;

    @Override
    public Packet getPacket(String appid)
    {
        QueryWrapper<Packet> wrapper = new QueryWrapper<>();
        wrapper.eq("appid", appid);
        return packetMapper.selectOne(wrapper);
    }
}
