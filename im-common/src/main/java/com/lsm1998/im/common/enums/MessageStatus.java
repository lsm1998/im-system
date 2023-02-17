package com.lsm1998.im.common.enums;

public enum MessageStatus
{
    /**
     * 未读
     */
    UNREAD(0),
    /**
     * 已读
     */
    READ(1),
    /**
     * 删除
     */
    DELETE(2);

    private final Integer value;

    MessageStatus(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }
}
