package com.lsm1998.im.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncrypt
{
    public static String generateSalt()
    {
        String salt = SHA256(String.valueOf(System.currentTimeMillis()));
        return salt.substring(0, 6);
    }

    public static String encrypt(String md5Str, String salt)
    {
        return SHA256(md5Str + salt);
    }

    public static boolean equals(String md5Str, String password, String salt)
    {
        return password.equals(encrypt(md5Str, salt));
    }

    private static String byte2Hex(byte[] bytes)
    {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte aByte : bytes)
        {
            String temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1)
            {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    public static String SHA256(String str)
    {
        MessageDigest messageDigest;
        String encodestr = null;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodestr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encodestr;
    }
}
