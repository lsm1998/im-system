package com.lsm1998.im.imadmin.internal.role.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorityScanData
{
    /**
     * 权限标识
     */
    private String authorityKey;

    /**
     * 关联状态，1关联，0未关联
     */
    private Integer relationState;
}
