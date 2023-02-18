package com.lsm1998.im.imcomet.grpc;

import com.lsm1998.im.imcomet.grpc.protobuf.Comet;
import com.lsm1998.im.imcomet.grpc.protobuf.CometServiceGrpc;
import com.lsm1998.im.imcomet.im.Buckets;
import com.lsm1998.im.imcomet.im.bucket.Bucket;
import io.grpc.stub.StreamObserver;
import jakarta.annotation.Resource;

public class CometService extends CometServiceGrpc.CometServiceImplBase
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
