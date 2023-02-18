package com.lsm1998.im.imjob.middleware.grpc;

import com.lsm1998.im.imjob.grpc.CometClient;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClient
{
    @Resource
    private GrpcClientConfig grpcClientConfig;

    @Bean
    public CometClient cometClient()
    {
        return new CometClient(grpcClientConfig.getHost(), grpcClientConfig.getPort(), null);
    }
}
