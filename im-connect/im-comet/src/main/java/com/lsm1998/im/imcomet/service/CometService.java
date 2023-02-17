package com.lsm1998.im.imcomet.service;

import com.lsm1998.im.imcomet.protobuf.Comet;
import com.lsm1998.im.imcomet.protobuf.CometServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CometService extends CometServiceGrpc.CometServiceImplBase
{
    @Override
    public void push(Comet.PushReq request, StreamObserver<Comet.Empty> responseObserver)
    {
        System.out.println(request);
        responseObserver.onNext(Comet.Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
