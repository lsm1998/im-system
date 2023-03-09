package com.lsm1998.im.imcomet.runner.im.protoc.encoded;

import com.lsm1998.im.imcomet.runner.im.protoc.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

import java.util.List;

/**
 * 消息解码器
 * <p>
 * command(4 byte) + 版本号 (4 byte) + 设备类型(4 byte) + 编码类型(1 byte) + body len(4 byte) + body
 */
public class MessageDecoder extends MessageToMessageDecoder<WebSocketFrame>
{
    private static final int MESSAGE_PROTOC_HEAD_LEN = 4 + 4 + 4 + 1 + 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, WebSocketFrame frame, List<Object> out) throws Exception
    {
        ByteBuf payload = frame.content();
        if (!frame.isFinalFragment() || payload.readableBytes() < MESSAGE_PROTOC_HEAD_LEN)
        {
            return;
        }
        Message message = new Message();
        // 命令
        message.setCommand(payload.readInt());

        // 版本号
        message.setVersion(payload.readInt());

        // 设备类型
        message.setDeviceType(payload.readInt());

        // 编码类型
        message.setEncodeType(payload.readByte());

        // body长度
        message.setBodyLen(payload.readInt());

        if (payload.readableBytes() < message.getBodyLen())
        {
            return;
        }

        byte[] body = new byte[message.getBodyLen()];
        payload.readBytes(body);
        message.setBody(body);
        // 读取完毕，重置读指针
        payload.resetReaderIndex();
        out.add(message);
    }
}
