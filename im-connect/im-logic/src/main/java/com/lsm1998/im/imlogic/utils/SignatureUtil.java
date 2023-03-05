package com.lsm1998.im.imlogic.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lsm1998.im.common.security.SHA256;
import com.lsm1998.im.common.security.MD5;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Date;

public class SignatureUtil
{
    public static String signature(long createTime, String secretKey, Object data) throws JsonProcessingException
    {
        JsonMapper mapper = new JsonMapper();
        return signature(createTime, secretKey, mapper.writeValueAsString(data));
    }

    public static String signature(long createTime, String secretKey, String bodyStr)
    {
        return signature(createTime, secretKey, bodyStr.getBytes());
    }

    public static String signature(long createTime, String secretKey, byte[] body)
    {
        try
        {
            Date date = new Date(createTime);
            /**
             * 签名规则
             *
             * signature = sha256(createTime + secretKey + md5(body))
             */
            return SHA256.encode(createTime + secretKey + MD5.encode(body));
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
}
