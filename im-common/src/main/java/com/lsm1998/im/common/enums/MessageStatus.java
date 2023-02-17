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

    private final Integer status;

    MessageStatus(int status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
}
