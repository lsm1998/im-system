package com.lsm1998.im.imcomet.im.bucket;

import com.lsm1998.im.imcomet.grpc.protobuf.Comet;
import lombok.Data;

@Data
public class Channel
{
    private Channel next;

    private Channel prev;

    public void push(Comet.Proto proto)
    {

    }

    public void close()
    {
    }
}
