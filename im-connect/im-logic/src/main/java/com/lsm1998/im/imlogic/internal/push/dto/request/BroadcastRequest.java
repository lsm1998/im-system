package com.lsm1998.im.imlogic.internal.push.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class BroadcastRequest implements Serializable
{
    private String fromId;

    private String type;

    private String content;
}
