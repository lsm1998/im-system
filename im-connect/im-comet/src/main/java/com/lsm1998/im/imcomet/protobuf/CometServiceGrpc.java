package com.lsm1998.im.imcomet.protobuf;

import jakarta.annotation.Generated;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * protoc -I=./ -I=../ --go_out=paths=source_relative:. --go-grpc_out=paths=source_relative:. reptilerpc/&#42;.proto
 * protoc --plugin=protoc-gen-grpc-java=source_relative:. --grpc-java_out=source_relative:. --proto_path=. comet.proto
 * D:/SoftWare/protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe  --grpc-java_out=source_relative:. --proto_path=.  comet.proto
 * </pre>
 */
@Generated(value = "by gRPC proto compiler (version 1.9.1)", comments = "Source: comet.proto")
public final class CometServiceGrpc
{

    private CometServiceGrpc()
    {
    }

    public static final String SERVICE_NAME = "im.CometService";

    // Static method descriptors that strictly reflect the proto.
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    @Deprecated // Use {@link #getPushMethod()} instead.
    public static final io.grpc.MethodDescriptor<com.lsm1998.im.imcomet.protobuf.Comet.PushReq,
            com.lsm1998.im.imcomet.protobuf.Comet.Empty> METHOD_PUSH = getPushMethod();

    private static volatile io.grpc.MethodDescriptor<com.lsm1998.im.imcomet.protobuf.Comet.PushReq,
            com.lsm1998.im.imcomet.protobuf.Comet.Empty> getPushMethod;

    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
    public static io.grpc.MethodDescriptor<com.lsm1998.im.imcomet.protobuf.Comet.PushReq,
            com.lsm1998.im.imcomet.protobuf.Comet.Empty> getPushMethod()
    {
        io.grpc.MethodDescriptor<com.lsm1998.im.imcomet.protobuf.Comet.PushReq, com.lsm1998.im.imcomet.protobuf.Comet.Empty> getPushMethod;
        if ((getPushMethod = CometServiceGrpc.getPushMethod) == null)
        {
            synchronized (CometServiceGrpc.class)
            {
                if ((getPushMethod = CometServiceGrpc.getPushMethod) == null)
                {
                    CometServiceGrpc.getPushMethod = getPushMethod =
                            io.grpc.MethodDescriptor.<com.lsm1998.im.imcomet.protobuf.Comet.PushReq, com.lsm1998.im.imcomet.protobuf.Comet.Empty>newBuilder()
                                    .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                                    .setFullMethodName(generateFullMethodName(
                                            "im.CometService", "Push"))
                                    .setSampledToLocalTracing(true)
                                    .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.lsm1998.im.imcomet.protobuf.Comet.PushReq.getDefaultInstance()))
                                    .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                                            com.lsm1998.im.imcomet.protobuf.Comet.Empty.getDefaultInstance()))
                                    .setSchemaDescriptor(new CometServiceMethodDescriptorSupplier("Push"))
                                    .build();
                }
            }
        }
        return getPushMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static CometServiceStub newStub(io.grpc.Channel channel)
    {
        return new CometServiceStub(channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static CometServiceBlockingStub newBlockingStub(
            io.grpc.Channel channel)
    {
        return new CometServiceBlockingStub(channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static CometServiceFutureStub newFutureStub(
            io.grpc.Channel channel)
    {
        return new CometServiceFutureStub(channel);
    }

    /**
     * <pre>
     * protoc -I=./ -I=../ --go_out=paths=source_relative:. --go-grpc_out=paths=source_relative:. reptilerpc/&#42;.proto
     * protoc --plugin=protoc-gen-grpc-java=source_relative:. --grpc-java_out=source_relative:. --proto_path=. comet.proto
     * D:/SoftWare/protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe  --grpc-java_out=source_relative:. --proto_path=.  comet.proto
     * </pre>
     */
    public static abstract class CometServiceImplBase implements io.grpc.BindableService
    {

        /**
         *
         */
        public void push(com.lsm1998.im.imcomet.protobuf.Comet.PushReq request,
                         io.grpc.stub.StreamObserver<com.lsm1998.im.imcomet.protobuf.Comet.Empty> responseObserver)
        {
            asyncUnimplementedUnaryCall(getPushMethod(), responseObserver);
        }

        @Override
        public final io.grpc.ServerServiceDefinition bindService()
        {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            getPushMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.lsm1998.im.imcomet.protobuf.Comet.PushReq,
                                            com.lsm1998.im.imcomet.protobuf.Comet.Empty>(
                                            this, METHODID_PUSH)))
                    .build();
        }
    }

    /**
     * <pre>
     * protoc -I=./ -I=../ --go_out=paths=source_relative:. --go-grpc_out=paths=source_relative:. reptilerpc/&#42;.proto
     * protoc --plugin=protoc-gen-grpc-java=source_relative:. --grpc-java_out=source_relative:. --proto_path=. comet.proto
     * D:/SoftWare/protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe  --grpc-java_out=source_relative:. --proto_path=.  comet.proto
     * </pre>
     */
    public static final class CometServiceStub extends io.grpc.stub.AbstractStub<CometServiceStub>
    {
        private CometServiceStub(io.grpc.Channel channel)
        {
            super(channel);
        }

        private CometServiceStub(io.grpc.Channel channel,
                                 io.grpc.CallOptions callOptions)
        {
            super(channel, callOptions);
        }

        @Override
        protected CometServiceStub build(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions)
        {
            return new CometServiceStub(channel, callOptions);
        }

        /**
         *
         */
        public void push(com.lsm1998.im.imcomet.protobuf.Comet.PushReq request,
                         io.grpc.stub.StreamObserver<com.lsm1998.im.imcomet.protobuf.Comet.Empty> responseObserver)
        {
            asyncUnaryCall(
                    getChannel().newCall(getPushMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * <pre>
     * protoc -I=./ -I=../ --go_out=paths=source_relative:. --go-grpc_out=paths=source_relative:. reptilerpc/&#42;.proto
     * protoc --plugin=protoc-gen-grpc-java=source_relative:. --grpc-java_out=source_relative:. --proto_path=. comet.proto
     * D:/SoftWare/protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe  --grpc-java_out=source_relative:. --proto_path=.  comet.proto
     * </pre>
     */
    public static final class CometServiceBlockingStub extends io.grpc.stub.AbstractStub<CometServiceBlockingStub>
    {
        private CometServiceBlockingStub(io.grpc.Channel channel)
        {
            super(channel);
        }

        private CometServiceBlockingStub(io.grpc.Channel channel,
                                         io.grpc.CallOptions callOptions)
        {
            super(channel, callOptions);
        }

        @Override
        protected CometServiceBlockingStub build(io.grpc.Channel channel,
                                                 io.grpc.CallOptions callOptions)
        {
            return new CometServiceBlockingStub(channel, callOptions);
        }

        /**
         *
         */
        public com.lsm1998.im.imcomet.protobuf.Comet.Empty push(com.lsm1998.im.imcomet.protobuf.Comet.PushReq request)
        {
            return blockingUnaryCall(
                    getChannel(), getPushMethod(), getCallOptions(), request);
        }
    }

    /**
     * <pre>
     * protoc -I=./ -I=../ --go_out=paths=source_relative:. --go-grpc_out=paths=source_relative:. reptilerpc/&#42;.proto
     * protoc --plugin=protoc-gen-grpc-java=source_relative:. --grpc-java_out=source_relative:. --proto_path=. comet.proto
     * D:/SoftWare/protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe  --grpc-java_out=source_relative:. --proto_path=.  comet.proto
     * </pre>
     */
    public static final class CometServiceFutureStub extends io.grpc.stub.AbstractStub<CometServiceFutureStub>
    {
        private CometServiceFutureStub(io.grpc.Channel channel)
        {
            super(channel);
        }

        private CometServiceFutureStub(io.grpc.Channel channel,
                                       io.grpc.CallOptions callOptions)
        {
            super(channel, callOptions);
        }

        @Override
        protected CometServiceFutureStub build(io.grpc.Channel channel,
                                               io.grpc.CallOptions callOptions)
        {
            return new CometServiceFutureStub(channel, callOptions);
        }

        /**
         *
         */
        public com.google.common.util.concurrent.ListenableFuture<com.lsm1998.im.imcomet.protobuf.Comet.Empty> push(
                com.lsm1998.im.imcomet.protobuf.Comet.PushReq request)
        {
            return futureUnaryCall(
                    getChannel().newCall(getPushMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_PUSH = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp>
    {
        private final CometServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(CometServiceImplBase serviceImpl, int methodId)
        {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver)
        {
            switch (methodId)
            {
                case METHODID_PUSH:
                    serviceImpl.push((com.lsm1998.im.imcomet.protobuf.Comet.PushReq) request,
                            (io.grpc.stub.StreamObserver<com.lsm1998.im.imcomet.protobuf.Comet.Empty>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(
                io.grpc.stub.StreamObserver<Resp> responseObserver)
        {
            switch (methodId)
            {
                default:
                    throw new AssertionError();
            }
        }
    }

    private static abstract class CometServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier
    {
        CometServiceBaseDescriptorSupplier()
        {
        }

        @Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor()
        {
            return com.lsm1998.im.imcomet.protobuf.Comet.getDescriptor();
        }

        @Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor()
        {
            return getFileDescriptor().findServiceByName("CometService");
        }
    }

    private static final class CometServiceFileDescriptorSupplier
            extends CometServiceBaseDescriptorSupplier
    {
        CometServiceFileDescriptorSupplier()
        {
        }
    }

    private static final class CometServiceMethodDescriptorSupplier
            extends CometServiceBaseDescriptorSupplier
            implements io.grpc.protobuf.ProtoMethodDescriptorSupplier
    {
        private final String methodName;

        CometServiceMethodDescriptorSupplier(String methodName)
        {
            this.methodName = methodName;
        }

        @Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor()
        {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor()
    {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null)
        {
            synchronized (CometServiceGrpc.class)
            {
                result = serviceDescriptor;
                if (result == null)
                {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                            .setSchemaDescriptor(new CometServiceFileDescriptorSupplier())
                            .addMethod(getPushMethod())
                            .build();
                }
            }
        }
        return result;
    }
}
