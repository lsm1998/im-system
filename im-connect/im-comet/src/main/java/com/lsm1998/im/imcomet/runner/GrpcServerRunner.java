package com.lsm1998.im.imcomet.runner;

import com.lsm1998.im.imcomet.config.GrpcServeConfig;
import com.lsm1998.im.imcomet.runner.grpc.CometService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Java gRPC 服务端
 * <p>
 * <a href="https://github.com/grpc/grpc-java">doc</a>
 */
@Component
@Slf4j
public class GrpcServerRunner implements ApplicationRunner
{
    private Server server;

    @Resource
    private GrpcServeConfig grpcServeConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        server = Grpc.newServerBuilderForPort(grpcServeConfig.getPort(), InsecureServerCredentials.create())
                .addService(new CometService())
                // .intercept(new ServerInterceptor())  // add the Interceptor
                .build()
                .start();

        log.info("gRPC Server started, listening on " + grpcServeConfig.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                server.shutdown();
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                this.interrupt();
                System.err.println("*** server shut down");
            }
        });
    }
}
