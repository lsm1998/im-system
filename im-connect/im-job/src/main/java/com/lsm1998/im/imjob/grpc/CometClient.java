package com.lsm1998.im.imjob.grpc;

import com.lsm1998.im.imjob.grpc.protobuf.Comet;
import com.lsm1998.im.imjob.grpc.protobuf.CometServiceGrpc;
import io.grpc.CallCredentials;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CometClient
{
    private final ManagedChannel channel;
    private final CometServiceGrpc.CometServiceBlockingStub blockingStub;
    private final CallCredentials callCredentials;

    public CometClient(String host, int port, CallCredentials callCredentials)
    {
        this(Grpc.newChannelBuilderForAddress(host, port, InsecureChannelCredentials.create())
                .build(), callCredentials);
    }

    public CometClient(ManagedChannel channel, CallCredentials callCredentials)
    {
        this.channel = channel;
        this.callCredentials = callCredentials;
        this.blockingStub = CometServiceGrpc.newBlockingStub(channel).withCallCredentials(callCredentials);
    }

    public void shutdown() throws InterruptedException
    {
        channel.shutdown().awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void push(Comet.PushReq request)
    {
        try
        {
            Comet.Empty empty = blockingStub
                    .withCallCredentials(callCredentials)
                    .push(request);
        } catch (Exception e)
        {
            log.error("CometClient push,err={}", e.getMessage());
        }
    }
}
