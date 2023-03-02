package com.lsm1998.im.tenant.middleware.interceptor;

import com.lsm1998.im.common.annotations.AccessPermission;
import com.lsm1998.im.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
    @Resource
    private ContextHolder contextHolder;

    @Value("${jwt.secretKey}")
    private String secretKey;

    private Long getUserId(String token) throws RuntimeException
    {
        JwtUtil.ClaimsParse claimsParse = JwtUtil.parseToken(secretKey, token);
        if (!claimsParse.isVerify())
        {
            throw new RuntimeException("token校验失败");
        } else if (claimsParse.isExpire())
        {
            throw new RuntimeException("token已过期");
        }
        Claims claims = claimsParse.getClaims();
        if (claims != null)
        {
            return claims.get("userId", Long.class);
        }
        return 0L;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception
    {
        contextHolder.setRemoteIp(request.getRemoteAddr());
        if (handler instanceof HandlerMethod method)
        {
            AccessPermission permission = method.getMethodAnnotation(AccessPermission.class);
            if (permission == null)
            {
                return true;
            }
            try
            {
                // 设置当前用户
                Long userId = getUserId(request.getHeader("token"));
                contextHolder.setUserId(userId);
            } catch (RuntimeException e)
            {
                response.setStatus(401);
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
