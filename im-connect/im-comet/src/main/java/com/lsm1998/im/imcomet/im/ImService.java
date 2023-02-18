package com.lsm1998.im.imcomet.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImService
{
    private final ServerBootstrap server;

    private final int port;

    private final String host;

    public ImService(String host, int port)
    {
        this.port = port;
        this.host = host;
        this.server = new ServerBootstrap();
    }

    public void start() throws InterruptedException
    {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();
        try
        {
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
            ChannelFuture future = server.bind(this.host, this.port).sync();
            log.info("IM服务端启动成功,host={},port={}", this.host, this.port);
            future.channel().closeFuture().sync();
        } finally
        {
            mainGroup.shutdownGracefully().sync();
            subGroup.shutdownGracefully().sync();
        }
    }
}
