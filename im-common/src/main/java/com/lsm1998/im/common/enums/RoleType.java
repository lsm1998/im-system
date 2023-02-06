package com.lsm1998.im.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum RoleType
{
    // 1基础 2用户创建
    BaseRole(1), UseRole(2);

    @EnumValue
    private final Integer value;

    RoleType(Integer value)
    {
        this.value = value;
    }

    public Integer getValue()
    {
        return value;
    }
}
