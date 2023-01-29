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
    private int port;

    public LimServer(int port)
    {
        this.port = port;

        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(mainGroup , subGroup).
                channel(NioServerSocketChannel.class).
                option(ChannelOption.SO_BACKLOG , 10240).
                option(ChannelOption.SO_REUSEADDR , true).
                option(ChannelOption.TCP_NODELAY , true).
                option(ChannelOption.SO_KEEPALIVE , true).
                childHandler(new ChannelInitializer<>()
                {
                    @Override
                    protected void initChannel(Channel channel) throws Exception
                    {

                    }
                });
        server.bind(this.port);
    }
}
