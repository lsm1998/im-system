package com.lsm1998.im.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BroadcastMessage implements Serializable
{
    private String fromId;

    private Integer type;

    private String content;
}
