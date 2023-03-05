package com.lsm1998.im.common.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SHA256
{
    public static String encode(byte[] bytes) throws NoSuchAlgorithmException
    {
        return MessageDigestAdapter.encode("SHA-256", bytes);
    }

    public static String encode(String str) throws NoSuchAlgorithmException
    {
        return encode(str.getBytes());
    }

    public static String encode(FileInputStream inputStream) throws NoSuchAlgorithmException, IOException
    {
        return MessageDigestAdapter.encodeWithStream("SHA-256", inputStream);
    }
}
