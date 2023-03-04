package com.lsm1998.im.common;

import javax.servlet.http.PushBuilder;

public class Code
{
    // OK
    public static final int OK_CODE = 200;
    public static final String OK_MESSAGE = "ok";

    public static final int SERVER_ERROR_CODE = 10001;
    public static final String SERVER_ERROR_MESSAGE = "服务内部错误";

    public static final int PARAM_ERROR_CODE = 10002;
    public static final String PARAM_ERROR_MESSAGE = "参数错误";


    public static final int LOGIN_ERROR_CODE = 20001;
    public static final String LOGIN_ERROR_MESSAGE = "登录失败";

    public static final int USER_NOT_EXIST_ERROR_CODE = 20002;
    public static final String USER_NOT_EXIST_ERROR_MESSAGE = "用户不存在";

    public static final int APPID_INSERT_ERROR_CODE = 20003;
    public static final String APPID_INSERT_ERROR_MESSAGE = "appid写入失败";

    public static final int ACCESS_TOKEN_CREATE_EXPIRE_CODE = 20004;
    public static final String ACCESS_TOKEN_CREATE_EXPIRE_MESSAGE = "accessToken创建过期";

    public static final int SIGNATURE_ERROR_CODE =20005;
    public static final String SIGNATURE_ERROR_MESSAGE = "签名错误";

    public static final int APPID_NOT_EXIST_CODE = 20006;
    public static final String APPID_NOT_EXIST_MESSAGE = "appid不存在";
}
