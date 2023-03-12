package com.lsm1998.im.imlogic.runner.grpc;

import com.lsm1998.im.protobuf.logic.ImLogicServiceGrpc;
import com.lsm1998.im.protobuf.logic.Logic;
import io.grpc.stub.StreamObserver;

public class LogicService extends ImLogicServiceGrpc.ImLogicServiceImplBase
{
    @Override
    public void handshake(Logic.HandshakeReq request, StreamObserver<Logic.HandshakeResp> responseObserver)
    {
        // 解析token 获取用户信息
        String token = request.getToken();
        System.out.println(request);
        responseObserver.onNext(Logic.HandshakeResp.newBuilder().build());
        responseObserver.onCompleted();
    }
}
