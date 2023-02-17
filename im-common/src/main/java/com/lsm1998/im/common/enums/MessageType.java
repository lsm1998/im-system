package com.lsm1998.im.common.enums;

public enum MessageType
{
    /**
     * ping
     */
    Ping(0),

    /**
     * 文本
     */
    TEXT(1),

    /**
     * 语音
     */
    VOICE(2),

    /**
     * 图片
     */
    IMAGE(3),

    /**
     * 视频
     */
    VIDEO(4),

    /**
     * 文件
     */
    FILE(5);

    private final Integer value;

    MessageType(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }
}
