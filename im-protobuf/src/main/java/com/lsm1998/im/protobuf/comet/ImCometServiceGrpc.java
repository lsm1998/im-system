package com.lsm1998.im.protobuf.comet;

import javax.annotation.processing.Generated;

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
 * protoc --java_out=. --proto_path=.  comet.proto
 * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. comet.proto
 * </pre>
 */
@Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: comet.proto")
public final class ImCometServiceGrpc {

  private ImCometServiceGrpc() {}

  public static final String SERVICE_NAME = "im.ImCometService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getPushMethod()} instead.
  public static final io.grpc.MethodDescriptor<Comet.PushReq,
      Comet.Empty> METHOD_PUSH = getPushMethod();

  private static volatile io.grpc.MethodDescriptor<Comet.PushReq,
      Comet.Empty> getPushMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Comet.PushReq,
      Comet.Empty> getPushMethod() {
    io.grpc.MethodDescriptor<Comet.PushReq, Comet.Empty> getPushMethod;
    if ((getPushMethod = ImCometServiceGrpc.getPushMethod) == null) {
      synchronized (ImCometServiceGrpc.class) {
        if ((getPushMethod = ImCometServiceGrpc.getPushMethod) == null) {
          ImCometServiceGrpc.getPushMethod = getPushMethod = 
              io.grpc.MethodDescriptor.<Comet.PushReq, Comet.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "im.ImCometService", "Push"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Comet.PushReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Comet.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ImCometServiceMethodDescriptorSupplier("Push"))
                  .build();
          }
        }
     }
     return getPushMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImCometServiceStub newStub(io.grpc.Channel channel) {
    return new ImCometServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImCometServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ImCometServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImCometServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ImCometServiceFutureStub(channel);
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  comet.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. comet.proto
   * </pre>
   */
  public static abstract class ImCometServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void push(Comet.PushReq request,
                     io.grpc.stub.StreamObserver<Comet.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getPushMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPushMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Comet.PushReq,
                Comet.Empty>(
                  this, METHODID_PUSH)))
          .build();
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  comet.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. comet.proto
   * </pre>
   */
  public static final class ImCometServiceStub extends io.grpc.stub.AbstractStub<ImCometServiceStub> {
    private ImCometServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImCometServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImCometServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImCometServiceStub(channel, callOptions);
    }

    /**
     */
    public void push(Comet.PushReq request,
                     io.grpc.stub.StreamObserver<Comet.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPushMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  comet.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. comet.proto
   * </pre>
   */
  public static final class ImCometServiceBlockingStub extends io.grpc.stub.AbstractStub<ImCometServiceBlockingStub> {
    private ImCometServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImCometServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImCometServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImCometServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Comet.Empty push(Comet.PushReq request) {
      return blockingUnaryCall(
          getChannel(), getPushMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  comet.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. comet.proto
   * </pre>
   */
  public static final class ImCometServiceFutureStub extends io.grpc.stub.AbstractStub<ImCometServiceFutureStub> {
    private ImCometServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImCometServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImCometServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImCometServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Comet.Empty> push(
        Comet.PushReq request) {
      return futureUnaryCall(
          getChannel().newCall(getPushMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUSH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImCometServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImCometServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUSH:
          serviceImpl.push((Comet.PushReq) request,
              (io.grpc.stub.StreamObserver<Comet.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ImCometServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImCometServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Comet.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImCometService");
    }
  }

  private static final class ImCometServiceFileDescriptorSupplier
      extends ImCometServiceBaseDescriptorSupplier {
    ImCometServiceFileDescriptorSupplier() {}
  }

  private static final class ImCometServiceMethodDescriptorSupplier
      extends ImCometServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImCometServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ImCometServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImCometServiceFileDescriptorSupplier())
              .addMethod(getPushMethod())
              .build();
        }
      }
    }
    return result;
  }
}
