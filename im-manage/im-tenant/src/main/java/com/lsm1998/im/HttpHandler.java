package com.lsm1998.im;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class HttpHandler implements com.sun.net.httpserver.HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        byte[] body = exchange.getRequestBody().readAllBytes();
        System.out.println(new String(body));
        byte[] response = "Hello World".getBytes();
        exchange.getResponseHeaders().set("Content-Type", "text/html;charset=utf-8");
        exchange.sendResponseHeaders(200, response.length);
        exchange.getResponseBody().write(response);
    }
}
