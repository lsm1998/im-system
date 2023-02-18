package com.lsm1998.im.imcomet.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class ImService
{
    private final ServerBootstrap server;

    private final int port;

    public ImService(int port) throws InterruptedException
    {
        this.port = port;
        this.server = new ServerBootstrap();
    }

    public void start() throws InterruptedException
    {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();
        try
        {
            server.bind(port);
            server.group(mainGroup, subGroup).
                    channel(NioServerSocketChannel.class).
                    option(ChannelOption.SO_BACKLOG, 10240).
                    option(ChannelOption.SO_REUSEADDR, true).
                    childOption(ChannelOption.TCP_NODELAY, true).
                    childOption(ChannelOption.SO_KEEPALIVE, true).

                    childHandler(new ChannelInitializer<>()
                    {
                        @Override
                        protected void initChannel(Channel channel) throws Exception
                        {
                            ChannelPipeline pipeline = channel.pipeline();
                            // HTTP编解码器
                            pipeline.addLast(new HttpServerCodec());
                            //  支持大数据流
                            pipeline.addLast(new ChunkedWriteHandler());
                            // 聚合器，使用websocket会用到
                            pipeline.addLast(new HttpObjectAggregator(8 * 1024));
                            // 自定义处理器
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                            // 自定义处理器
                            // pipeline.addLast(new ImHandler());
                        }
                    });
        } finally
        {
            mainGroup.shutdownGracefully().sync();
            subGroup.shutdownGracefully().sync();
        }
    }
}
