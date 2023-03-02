package com.lsm1998.im.tenant.internal.account.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lsm1998.im.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tenant_packet")
public class Packet extends BaseModel
{
    /**
     * appid
     */
    private String appid;

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

    /**
     * 积分
     */
    private Integer integral;

    /**
     * 等级
     */
    private Integer level;
}
