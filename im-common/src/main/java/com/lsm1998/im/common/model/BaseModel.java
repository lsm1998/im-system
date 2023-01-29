package com.lsm1998.im.common.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseModel implements Serializable
{
    private Long id;

    private Date createTime;

    private Date updateTime;
}
