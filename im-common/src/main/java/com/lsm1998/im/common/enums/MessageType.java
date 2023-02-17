package com.lsm1998.im.common.enums;

public enum MessageType
{
    TEXT(0), VOICE(1), IMAGE(2), VIDEO(3), FILE(4);

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
