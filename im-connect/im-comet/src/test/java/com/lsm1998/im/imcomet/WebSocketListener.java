package com.lsm1998.im.imcomet;

import java.net.http.WebSocket;

public class WebSocketListener implements WebSocket.Listener
{
    @Override
    public void onOpen(WebSocket webSocket)
    {
        System.out.println("onOpen");
    }
}
