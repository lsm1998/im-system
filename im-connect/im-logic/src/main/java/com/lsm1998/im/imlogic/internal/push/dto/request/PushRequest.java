package com.lsm1998.im.imlogic.internal.push.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PushRequest implements Serializable
{
    /**
     * 发送者id
     */
    private Long fromId;

    /**
     * 接收者id
     */
    private Long toId;

    /**
     * 消息类型
     */
    private String type;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息扩展
     */
    private String ext;
}
