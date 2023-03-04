package com.lsm1998.im.imlogic.internal.user.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CreateAccessTokenRequest
{
    /**
     * appid
     */
    private String appid;

    /**
     * mid
     */
    private String mid;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 签名
     */
    private String signature;

    @JsonIgnore
    private byte[] body;
}
