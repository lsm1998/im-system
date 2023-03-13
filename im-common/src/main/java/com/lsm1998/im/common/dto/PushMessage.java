package com.lsm1998.im.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PushMessage implements Serializable
{
    private String nodeId;

    private Integer type;

    private String formMid;

    private String[] toMid;

    private String content;

    private String ext;
}
