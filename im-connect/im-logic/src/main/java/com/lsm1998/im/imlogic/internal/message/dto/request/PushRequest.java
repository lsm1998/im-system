package com.lsm1998.im.imlogic.internal.message.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PushRequest implements Serializable
{
    private Long fromId;

    private Long toId;

    private String type;

    private String content;

    private String ext;
}
