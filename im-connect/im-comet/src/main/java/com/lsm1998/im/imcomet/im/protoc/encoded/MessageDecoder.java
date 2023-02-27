package com.lsm1998.im.imcomet.im.protoc.encoded;

import com.lsm1998.im.imcomet.im.protoc.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

/**
 * 消息解码器
 * <p>
 * command(4 byte) + 版本号 (4 byte) + 设备类型(4 byte) + 编码类型(1 byte) + body len(4 byte) + body
 */
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf>
{
    private static final int MESSAGE_PROTOC_HEAD_LEN = 4 + 4 + 4 + 1 + 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
    {
        Message message = new Message();
        if (in.readableBytes() < MESSAGE_PROTOC_HEAD_LEN)
        {
            return;
        }

        // 命令
        message.setCommand(in.readInt());

        // 版本号
        message.setVersion(in.readInt());

        // 设备类型
        message.setDeviceType(in.readInt());

        // 编码类型
        message.setEncodeType(in.readByte());

        // body长度
        message.setBodyLen(in.readInt());

        if (in.readableBytes() < message.getBodyLen())
        {
            return;
        }

        byte[] body = new byte[message.getBodyLen()];
        message.setBody(in.readBytes(body).array());

        // 读取完毕，重置读指针
        in.resetReaderIndex();

        out.add(message);
    }
}
