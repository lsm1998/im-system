package com.lsm1998.im.imcomet;

import com.lsm1998.im.imcomet.runner.im.protoc.Message;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

public class CometTests
{
    public byte[] buildMessage(Message message) throws IOException
    {
        if (message.getBody() == null)
        {
            message.setBody(new byte[]{});
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream oos = new DataOutputStream(baos);
        oos.writeInt(message.getCommand());
        oos.writeInt(message.getVersion());
        oos.writeInt(message.getDeviceType());
        oos.writeByte(message.getEncodeType());
        oos.writeInt(message.getBody().length);
        baos.writeBytes(message.getBody());
        return baos.toByteArray();
    }

    @Test
    public void clientTest() throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> future = client.newWebSocketBuilder()
                .buildAsync(new URI("ws://localhost:8888/ws"), new WebSocketListener());
        WebSocket webSocket = future.get();

        Message message = new Message();
        message.setCommand(1);
        message.setVersion(59);
        message.setDeviceType(14);
        message.setEncodeType((byte) 1);
        message.setBody("hello".getBytes());
        for (int i = 0; i < 100; i++)
        {
            webSocket.sendBinary(ByteBuffer.wrap(buildMessage(message)), true);
        }
        webSocket.abort();
    }
}
