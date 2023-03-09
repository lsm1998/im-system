package com.lsm1998.im.imcomet.runner.im.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartbeatHandler extends ChannelInboundHandlerAdapter
{
    private long readTimeout = 0;

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception
    {
        IdleStateEvent event = (IdleStateEvent) evt;
        log.info("触发了: {}事件", event.state());
        if (event.state() == IdleState.READER_IDLE && ++readTimeout > 3)
        {
            String key = ctx.name();
            log.info("连接心跳超时");
            ctx.close();
        }
    }
}
