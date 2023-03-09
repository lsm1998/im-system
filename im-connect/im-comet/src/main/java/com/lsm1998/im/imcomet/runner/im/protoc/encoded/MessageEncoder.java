package com.lsm1998.im.imcomet.runner.im.protoc.encoded;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.List;

/**
 * 消息编码码器
 * <p>
 * command(4 byte) + 版本号 (4 byte) + 设备类型(4 byte) + 编码类型(1 byte) + body len(4 byte) + body
 */
public class MessageEncoder extends MessageToMessageEncoder<WebSocketFrame>
{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, List<Object> list) throws Exception
    {
        ByteBuf payload = webSocketFrame.content();
        list.add(payload);
    }
}
