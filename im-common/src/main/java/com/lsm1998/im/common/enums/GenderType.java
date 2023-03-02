package com.lsm1998.im.common.enums;

public enum GenderType
{
    /**
     * 男
     */
    Man("男"),

    /**
     * 女
     */
    WoMan("女"),

    /**
     * 未知
     */
    Unknown("未知");

    private final String value;

    GenderType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
