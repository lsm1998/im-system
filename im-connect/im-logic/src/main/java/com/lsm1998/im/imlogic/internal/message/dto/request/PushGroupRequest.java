package com.lsm1998.im.imlogic.internal.message.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PushGroupRequest implements Serializable
{
    private Long fromId;

    private Long groupId;

    private String type;

    private String content;
}
