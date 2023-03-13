package com.lsm1998.im.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupMessage implements Serializable
{
    private Long froMid;

    private Long groupId;

    private Integer type;

    private String content;

    private String ext;
}
