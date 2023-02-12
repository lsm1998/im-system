package com.lsm1998.im.common;

import java.util.HashMap;

import static com.lsm1998.im.common.Code.*;


public class AjaxResponse extends HashMap<String, Object>
{
    public AjaxResponse(int initialCapacity)
    {
        super(initialCapacity);
    }

    public static AjaxResponse of(int code, String message)
    {
        return AjaxResponse.of(code, message, null);
    }

    public static AjaxResponse of(int code, String message, Object data)
    {
        AjaxResponse response = new AjaxResponse(4);
        response.put("code", code);
        response.put("message", message);
        response.put("data", data);
        response.put("time", System.currentTimeMillis() / 1000);
        return response;
    }

    public static AjaxResponse failWithParam()
    {
        return AjaxResponse.of(PARAM_ERROR_CODE, PARAM_ERROR_MESSAGE, null);
    }

    public static AjaxResponse fail(int code, String message)
    {
        return AjaxResponse.of(code, message, null);
    }

    public static AjaxResponse fail(String message)
    {
        return AjaxResponse.of(SERVER_ERROR_CODE, message, null);
    }

    public static AjaxResponse fail()
    {
        return AjaxResponse.of(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE, null);
    }

    public static AjaxResponse success()
    {
        return AjaxResponse.of(OK_CODE, OK_MESSAGE, null);
    }

    public static AjaxResponse success(Object data)
    {
        return AjaxResponse.of(OK_CODE, OK_MESSAGE, data);
    }
}
