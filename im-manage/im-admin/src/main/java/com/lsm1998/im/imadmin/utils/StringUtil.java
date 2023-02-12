package com.lsm1998.im.imadmin.utils;

import org.springframework.util.ObjectUtils;

import java.util.Random;

public class StringUtil
{
    public static String randomStr(int len, char[] seed)
    {
        if (len == 0 || ObjectUtils.isEmpty(seed))
        {
            return "";
        }
        Random random = new Random(System.currentTimeMillis());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++)
        {
            result.append(seed[random.nextInt(seed.length)]);
        }
        return result.toString();
    }
}
