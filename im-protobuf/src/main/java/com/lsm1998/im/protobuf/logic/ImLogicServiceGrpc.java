package com.lsm1998.im.protobuf.logic;

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
 * protoc --java_out=. --proto_path=.  logic.proto
 * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. logic.proto
 * </pre>
 */
@Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: logic.proto")
public final class ImLogicServiceGrpc {

  private ImLogicServiceGrpc() {}

  public static final String SERVICE_NAME = "im.ImLogicService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @Deprecated // Use {@link #getHandshakeMethod()} instead.
  public static final io.grpc.MethodDescriptor<Logic.HandshakeReq,
      Logic.HandshakeResp> METHOD_HANDSHAKE = getHandshakeMethod();

  private static volatile io.grpc.MethodDescriptor<Logic.HandshakeReq,
      Logic.HandshakeResp> getHandshakeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Logic.HandshakeReq,
      Logic.HandshakeResp> getHandshakeMethod() {
    io.grpc.MethodDescriptor<Logic.HandshakeReq, Logic.HandshakeResp> getHandshakeMethod;
    if ((getHandshakeMethod = ImLogicServiceGrpc.getHandshakeMethod) == null) {
      synchronized (ImLogicServiceGrpc.class) {
        if ((getHandshakeMethod = ImLogicServiceGrpc.getHandshakeMethod) == null) {
          ImLogicServiceGrpc.getHandshakeMethod = getHandshakeMethod = 
              io.grpc.MethodDescriptor.<Logic.HandshakeReq, Logic.HandshakeResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "im.ImLogicService", "Handshake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Logic.HandshakeReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Logic.HandshakeResp.getDefaultInstance()))
                  .setSchemaDescriptor(new ImLogicServiceMethodDescriptorSupplier("Handshake"))
                  .build();
          }
        }
     }
     return getHandshakeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ImLogicServiceStub newStub(io.grpc.Channel channel) {
    return new ImLogicServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImLogicServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ImLogicServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ImLogicServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ImLogicServiceFutureStub(channel);
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  logic.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. logic.proto
   * </pre>
   */
  public static abstract class ImLogicServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void handshake(Logic.HandshakeReq request,
                          io.grpc.stub.StreamObserver<Logic.HandshakeResp> responseObserver) {
      asyncUnimplementedUnaryCall(getHandshakeMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHandshakeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Logic.HandshakeReq,
                Logic.HandshakeResp>(
                  this, METHODID_HANDSHAKE)))
          .build();
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  logic.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. logic.proto
   * </pre>
   */
  public static final class ImLogicServiceStub extends io.grpc.stub.AbstractStub<ImLogicServiceStub> {
    private ImLogicServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImLogicServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImLogicServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImLogicServiceStub(channel, callOptions);
    }

    /**
     */
    public void handshake(Logic.HandshakeReq request,
                          io.grpc.stub.StreamObserver<Logic.HandshakeResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getHandshakeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  logic.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. logic.proto
   * </pre>
   */
  public static final class ImLogicServiceBlockingStub extends io.grpc.stub.AbstractStub<ImLogicServiceBlockingStub> {
    private ImLogicServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImLogicServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImLogicServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImLogicServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Logic.HandshakeResp handshake(Logic.HandshakeReq request) {
      return blockingUnaryCall(
          getChannel(), getHandshakeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * protoc --java_out=. --proto_path=.  logic.proto
   * protoc --plugin=protoc-gen-grpc-java=C:&#92;Users&#92;Administrator&#92;go&#92;bin&#92;protoc-gen-grpc-java.exe --grpc-java_out=source_relative:. --proto_path=. logic.proto
   * </pre>
   */
  public static final class ImLogicServiceFutureStub extends io.grpc.stub.AbstractStub<ImLogicServiceFutureStub> {
    private ImLogicServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ImLogicServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ImLogicServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ImLogicServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Logic.HandshakeResp> handshake(
        Logic.HandshakeReq request) {
      return futureUnaryCall(
          getChannel().newCall(getHandshakeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HANDSHAKE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImLogicServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImLogicServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HANDSHAKE:
          serviceImpl.handshake((Logic.HandshakeReq) request,
              (io.grpc.stub.StreamObserver<Logic.HandshakeResp>) responseObserver);
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

  private static abstract class ImLogicServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImLogicServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Logic.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImLogicService");
    }
  }

  private static final class ImLogicServiceFileDescriptorSupplier
      extends ImLogicServiceBaseDescriptorSupplier {
    ImLogicServiceFileDescriptorSupplier() {}
  }

  private static final class ImLogicServiceMethodDescriptorSupplier
      extends ImLogicServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImLogicServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ImLogicServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ImLogicServiceFileDescriptorSupplier())
              .addMethod(getHandshakeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
