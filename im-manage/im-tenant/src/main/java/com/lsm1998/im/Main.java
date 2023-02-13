package com.lsm1998.im;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8080), 0);
        server.createContext("/", new HttpHandler());
        server.createContext("/tenant", new HttpHandler());
        server.start();
    }
}
