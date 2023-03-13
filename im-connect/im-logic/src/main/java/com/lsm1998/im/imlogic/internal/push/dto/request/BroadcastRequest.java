package com.lsm1998.im.imlogic.internal.push.dto.request;

import com.lsm1998.im.common.enums.MessageType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BroadcastRequest implements Serializable
{
    private String froMid;

    @NotEmpty(message = "消息类型不得为空")
    private MessageType type;

    private String content;
}
