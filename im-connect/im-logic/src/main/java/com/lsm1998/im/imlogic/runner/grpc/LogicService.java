package com.lsm1998.im.imlogic.runner.grpc;

import com.lsm1998.im.imlogic.internal.user.service.UserService;
import com.lsm1998.im.protobuf.logic.ImLogicServiceGrpc;
import com.lsm1998.im.protobuf.logic.Logic;
import io.grpc.stub.StreamObserver;

public class LogicService extends ImLogicServiceGrpc.ImLogicServiceImplBase
{
    private final UserService userService;

    public LogicService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public void handshake(Logic.HandshakeReq request, StreamObserver<Logic.HandshakeResp> responseObserver)
    {
        // handshake逻辑
        userService.handshake(request.getAppid(), request.getToken(), request.getNodeId());
        responseObserver.onNext(Logic.HandshakeResp.newBuilder().build());
        responseObserver.onCompleted();
    }
}
