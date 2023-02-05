package com.lsm1998.im.imadmin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Builder;
import lombok.Data;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JwtUtil
{
    public static String createToken(String secretKey, long expire, Map<String, Object> claimMap)
    {
        long currentTimeMillis = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date(currentTimeMillis))
                .setExpiration(new Date(currentTimeMillis + expire))
                .addClaims(claimMap)
                .signWith(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName()))
                .compact();
    }

    public static ClaimsParse parseToken(String secretKey, String token)
    {
        try
        {
            Claims claims = Jwts.parserBuilder().
                    setSigningKey(new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName())).
                    build()
                    .parseClaimsJws(token)
                    .getBody();
            return ClaimsParse.builder().isVerify(true).claims(claims).build();
        } catch (ExpiredJwtException e)
        {
            return ClaimsParse.builder().isVerify(true).isExpire(true).build();
        } catch (Exception e)
        {
            return ClaimsParse.builder().build();
        }
    }

    @Data
    @Builder
    public static class ClaimsParse
    {
        private Claims claims;

        private boolean isVerify;

        private boolean isExpire;
    }
}
