package com.lsm1998.im.imadmin.internal.tenant.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@TableName("tenant_base_packet")
@Data
public class TenantBasePacket extends BaseModel
{
    /**
     * 租户
     */
    private Long tenantId;

    /**
     * 群聊数量限制
     */
    private Integer groupCountLimit;

    /**
     * 群聊人数限制
     */
    private Integer groupUserLimit;

    /**
     * 用户人数限制
     */
    private Integer userLimit;
}
