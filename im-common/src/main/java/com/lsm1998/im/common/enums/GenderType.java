package com.lsm1998.im.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public String getValue()
    {
        return value;
    }
}
