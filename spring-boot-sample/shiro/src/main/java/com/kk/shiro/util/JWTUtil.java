package com.kk.shiro.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kk.shiro.shiro.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;
@Component
public class JWTUtil {

    private static String encryptJWTKey ="encryptJWTKey";
    /**
     * 校验token是否正确
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String username ) {
        try {
            byte[] hellos = new BASE64Decoder().decodeBuffer("hello");
            String base64encrypt = new String(hellos);
            String secret = username +base64encrypt ;
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(SecurityConsts.ACCOUNT, username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(SecurityConsts.ACCOUNT).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 获得Token中的信息无需secret解密也能获得
     * @param token
     * @param claim
     * @return
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     * @param account 用户名
     * @param
     * @return 加密的token
     */
    public static String sign(String account , String currentTimeMillis) {
        try {
            byte[] hellos = new BASE64Decoder().decodeBuffer("hello");
            String base64encrypt = new String(hellos);
            String secret = account +base64encrypt ;
            Date date = new Date(System.currentTimeMillis()+SecurityConsts.TOKEN_TIME_MAX);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带username信息
            return JWT.create()
                    .withClaim(SecurityConsts.ACCOUNT, account)
                    .withClaim(SecurityConsts.CURRENT_TIME_MILLIS,currentTimeMillis)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        } catch (IOException e){
            return null;
        }
    }

    private static RedisTemplate redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        JWTUtil.redisTemplate = redisTemplate;
    }

    public static RedisTemplate<String,Object> getRedisTemplate(){
        return redisTemplate;
    }

}
