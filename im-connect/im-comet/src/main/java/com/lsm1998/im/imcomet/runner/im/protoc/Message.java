package com.lsm1998.im.imcomet.runner.im.protoc;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable
{
    private int command;

    private int version;

    private int deviceType;

    private byte encodeType;

    private int bodyLen;

    private byte[] body;
}
