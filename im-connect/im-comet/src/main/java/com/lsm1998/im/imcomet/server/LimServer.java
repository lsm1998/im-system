package com.lsm1998.im.imcomet.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class LimServer
{
    private final ServerBootstrap server;

    public LimServer()
    {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        this.server = new ServerBootstrap();
        server.group(mainGroup, subGroup).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_BACKLOG, 10240).
                option(ChannelOption.SO_REUSEADDR, true).
                //option(ChannelOption.TCP_NODELAY, true).
                //option(ChannelOption.SO_KEEPALIVE, true).
                childHandler(new ChannelInitializer<>()
                {
                    @Override
                    protected void initChannel(Channel channel) throws Exception
                    {
                    }
                });
    }

    public void bind(int port)
    {
        server.bind(port);
    }
}
