package com.lsm1998.im.imjob.internal.push.service.impl;

import com.lsm1998.im.imjob.grpc.CometClient;
import com.lsm1998.im.imjob.internal.push.service.PushService;
import com.lsm1998.im.protobuf.comet.Comet;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PushServiceImpl implements PushService
{
    @Resource
    private CometClient cometClient;

    public void push()
    {
        Comet.PushReq request = Comet.PushReq.newBuilder()
                .setProtoOp(1)
                .build();
        cometClient.push(request);
    }
}
