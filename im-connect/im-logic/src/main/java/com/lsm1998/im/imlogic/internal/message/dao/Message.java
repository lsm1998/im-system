package com.lsm1998.im.imlogic.internal.message.dao;

import com.lsm1998.im.common.enums.MessageStatus;
import com.lsm1998.im.common.enums.MessageType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "message")
@Data
public class Message implements Serializable
{
    /**
     * 消息id
     */
    @Id
    private Long id;

    /**
     * 发送者id
     */
    private Long fromId;

    /**
     * 接收者id
     */
    private Long toId;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 消息扩展
     */
    private String ext;

    /**
     * 消息类型
     */
    private MessageType type;

    /**
     * 发送端状态
     */
    @Enumerated(EnumType.ORDINAL)
    private MessageStatus formStatus;

    /**
     * 接收端状态
     */
    @Enumerated(EnumType.ORDINAL)
    private MessageStatus toStatus;

    /**
     * 消息状态
     */
    private Integer status;

    /**
     * 消息创建时间
     */
    private Date createTime;
}
