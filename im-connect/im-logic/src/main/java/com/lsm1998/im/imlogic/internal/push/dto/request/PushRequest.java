package com.lsm1998.im.imlogic.internal.push.dto.request;

import com.lsm1998.im.common.enums.MessageType;
import com.lsm1998.im.imlogic.internal.message.dao.Message;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PushRequest implements Serializable
{
    /**
     * 发送者id
     */
    @NotEmpty(message = "发送者id不得为空")
    private String fromMid;

    /**
     * 接收者id
     */
    @NotEmpty(message = "接收者id不得为空")
    private String[] toMid;

    /**
     * 消息类型
     */
    @NotEmpty(message = "消息类型不得为空")
    private MessageType type;

    /**
     * 消息内容
     */
    @NotEmpty(message = "消息内容不得为空")
    private String content;

    /**
     * 消息扩展
     */
    private String ext;

    public Message ToMessage()
    {
        Message message = new Message();
        message.setContent(content);
        message.setExt(ext);
        message.setType(type);
        return message;
    }
}
