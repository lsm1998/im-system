package com.lsm1998.im.common.security;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestAdapter
{
    private static final int BUFFER_SIZE = 4096;

    public static String encode(String algorithm, byte[] bytes) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] digest = md.digest(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : digest)
        {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String encodeWithStream(String algorithm, InputStream inputStream) throws NoSuchAlgorithmException, IOException
    {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        try (DigestInputStream dis = new DigestInputStream(inputStream, md))
        {
            byte[] buffer = new byte[BUFFER_SIZE];
            int i;
            do
            {
                // 读取文件内容
                i = dis.read(buffer);
            } while (i != -1);
        }
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest)
        {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
