package com.lsm1998.im.imcomet.runner.grpc;

import com.lsm1998.im.imcomet.runner.im.wrap.Buckets;
import com.lsm1998.im.imcomet.runner.im.wrap.bucket.Bucket;
import com.lsm1998.im.protobuf.comet.Comet;
import com.lsm1998.im.protobuf.comet.ImCometServiceGrpc;
import io.grpc.stub.StreamObserver;
import jakarta.annotation.Resource;

public class CometService extends ImCometServiceGrpc.ImCometServiceImplBase
{
    @Resource
    private Buckets buckets;

    @Override
    public void push(Comet.PushReq request, StreamObserver<Comet.Empty> responseObserver)
    {
        for (String key : request.getKeysList())
        {
            Bucket bucket = buckets.getBucket(key);

            switch (request.getProtoOp())
            {
                // 0:ping
                case 0 -> bucket.getChannel(key).push(request.getProto());
                // 1:私聊
                case 1 -> bucket.getChannel(key).push(request.getProto());
            }
        }
        System.out.println(request);
        responseObserver.onNext(Comet.Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
