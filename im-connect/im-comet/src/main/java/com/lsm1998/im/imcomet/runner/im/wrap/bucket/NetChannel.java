package com.lsm1998.im.imcomet.runner.im.wrap.bucket;

import com.lsm1998.im.protobuf.comet.Comet;
import io.netty.channel.Channel;
import lombok.Data;

import java.net.SocketAddress;

@Data
public class NetChannel
{
    private Room room;

    private NetChannel next;

    private NetChannel prev;

    private String key;

    private long mid;

    private Channel channel;

    public NetChannel(Channel channel)
    {
        this.channel = channel;
    }

    public void push(Comet.Proto proto)
    {
        this.channel.write(proto.toByteArray());
    }

    public SocketAddress remoteAddress()
    {
        return this.channel.remoteAddress();
    }

    public void close()
    {
        this.channel.close();
    }
}
