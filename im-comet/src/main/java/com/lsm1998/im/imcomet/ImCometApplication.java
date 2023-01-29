package com.lsm1998.im.imcomet;

import com.lsm1998.im.imcomet.server.LimServer;

public class ImCometApplication
{
    public static void main(String[] args)
    {
        LimServer server = new LimServer();
        server.bind(9090);
    }
}
