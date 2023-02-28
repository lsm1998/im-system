package com.lsm1998.im.imcomet.im.gateway;

import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionSocketHolder
{
    private static final Map<String , NioSocketChannel> Channels = new ConcurrentHashMap<>();

    public static void put(NioSocketChannel channel)
    {
        Channels.put(channel.remoteAddress().getHostName(), channel);
    }

    public static void put(String sessionId, NioSocketChannel channel)
    {
        Channels.put(sessionId, channel);
    }

    public static NioSocketChannel get(String sessionId)
    {
        return Channels.get(sessionId);
    }
}
