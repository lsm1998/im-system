package com.lsm1998.im.imcomet.im.bucket;

import com.lsm1998.im.protobuf.comet.Comet;
import lombok.Data;

@Data
public class Channel
{
    private Room room;

    private Channel next;

    private Channel prev;

    private String key;

    private String ip;

    private long mid;

    public void push(Comet.Proto proto)
    {

    }

    public void close()
    {
    }
}
