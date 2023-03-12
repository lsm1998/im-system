package com.lsm1998.im.imcomet.runner.im.protoc.encoded;

import com.lsm1998.im.imcomet.runner.im.protoc.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 消息编码码器
 * <p>
 * command(4 byte) + 版本号 (4 byte) + 设备类型(4 byte) + 编码类型(1 byte) + body len(4 byte) + body
 */
public class MessageEncoder extends MessageToByteEncoder<Message>
{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf buf) throws Exception
    {
        buf.writeInt(message.getCommand());
        buf.writeInt(message.getVersion());
        buf.writeInt(message.getVersion());
        buf.writeInt(message.getEncodeType());
        if (ObjectUtils.isEmpty(message.getBody()))
        {
            message.setBody(new byte[]{});
        }
        buf.writeInt(message.getBody().length);
        buf.writeBytes(message.getBody());
    }
}
