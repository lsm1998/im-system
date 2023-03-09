package com.lsm1998.im.imcomet.runner.im.handler;

import com.lsm1998.im.imcomet.runner.im.protoc.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscardServerHandler extends SimpleChannelInboundHandler<Message>
{
    /**
     * 上线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception
    {
        log.info("上线");
    }

    /**
     * 收到消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception
    {
        log.info("收到消息 {}", msg);
    }

    /**
     * 下线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        log.info("下线");
    }
}
