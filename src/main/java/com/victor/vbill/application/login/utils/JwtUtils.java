package com.victor.vbill.application.login.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * JWT 工具类
 *
 * @date 2024/11/22
 */
@Slf4j
public class JwtUtils {
    // jwt 的超时时间为 1h
    private static final Long EXPIRE_TIME = 60 * 60 * 1000L;
    // 加密算法
    public static MacAlgorithm ALGORITHM = Jwts.SIG.HS512;
    // todo: 密钥设计成定期动态修改
    public static final SecretKey SECRET = ALGORITHM.key().build();

    public static String generateToken(String username) {
        Date now = new Date();
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expireDate)
                .signWith(SECRET, ALGORITHM)
                .compact();
    }

    public static Boolean validateToken(String token, String username) {
        try {
            byte[] payload = Jwts.parser()
                    .verifyWith(SECRET)
                    .build()
                    .parseSignedContent(token)
                    .getPayload();
            return username.equals(new String(payload, StandardCharsets.UTF_8));
        } catch (ExpiredJwtException expiredJwtException) {
            log.error("token expired");
        } catch (Exception e) {
            log.error("something error. error: {}", e.getMessage());
        }

        return false;
    }

}
