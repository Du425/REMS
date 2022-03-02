package com.du.rems.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author DU425
 * @Date 2022/3/1 19:54
 * @Version 1.0
 * @Description
 */
public class JwtTokenUtils {

    @Value("${du.jwt.secret}")
    private static String secret;

    @Value("${du.jwt.expire}")
    public static long expire;

    @Value("${du.jwt.header}")
    public static String header;

    @Value("${du.jwt.prefix}")
    public static String prefix;

    private static final String ISS = "Du425";

    private static final long EXPIRE_REMEMBER = 604800L;

    /**
     * 创建token
     * @param username
     * @param isRemember
     * @return
     */
    public static String createToken(String username, boolean isRemember){
        String token = null;
        try {
            long expiration = isRemember? EXPIRE_REMEMBER : expire;
            HashMap<String, Object> map = new HashMap<>();

            token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .setClaims(map)
                    .setIssuer(ISS)
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + expiration*1000))
                    .compact();
        }catch (ExpiredJwtException e){
            e.getClaims();
        }
        return token;
    }

    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
