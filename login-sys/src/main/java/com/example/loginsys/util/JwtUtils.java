package com.example.loginsys.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.loginsys.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Calendar;
import java.util.Date;

public class JwtUtils {
    //通过有效时间
    private static int days = 7;

    //密钥（需要后端严密保存）
    private static String SecretKey = "upw";

    /**
     *  生成token header.payload.sing
     */
    public static String getToken(User users, int day){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,day);
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        //payload
        builder.withClaim("id", users.getId());
        builder.withClaim("email", users.getEmail());
        //生成token，头部默认jwt和Base64编码
        String token = builder.withExpiresAt(instance.getTime())   //设置过期时间
                .sign(Algorithm.HMAC256(SecretKey));		//加密算法和密钥
        return token;
    }
    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 从令牌中获取数据声明,如果看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 验证 token 合法性
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SecretKey)).build().verify(token);
    }

}
