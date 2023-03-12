package com.lsm1998.im.imlogic.runner;

import com.lsm1998.im.imlogic.middleware.grpc.GrpcServeConfig;
import com.lsm1998.im.imlogic.runner.grpc.LogicService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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
                .addService(new LogicService())
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
