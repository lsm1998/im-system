package com.lsm1998.im.common;

public class Code
{
    // OK
    public static final int OK_CODE = 200;
    public static final String OK_MESSAGE = "ok";

    public static final int SERVER_ERROR_CODE = 500;
    public static final String SERVER_ERROR_MESSAGE = "服务内部错误";

    // 服务内部错误
    public static final int LOGIN_ERROR_CODE = 410;
    public static final String LOGIN_ERROR_MESSAGE = "登录失败";
    public static final int USER_NOT_EXIST_ERROR_CODE = 411;
    public static final String USER_NOT_EXIST_ERROR_MESSAGE = "用户不存在";

    // 参数错误
    public static final int PARAM_ERROR_CODE = 501;
    public static final String PARAM_ERROR_MESSAGE = "参数错误";
}
