package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.LocalTime;

/**
 * @ClassName Test
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Test {
    static  long time=0;
    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String token = encrypt.getToken(true, "zhent", "软件1851","19850099292");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("username: " + jwt.getClaim("username").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("phoneNumber:"+jwt.getClaim("phoneNumber").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());
        long currentTime=System.currentTimeMillis();
        System.out.println("当前时间："+ LocalTime.now());
        time=jwt.getExpiresAt().getTime();
        System.out.println("此时的token暂未失效");
        while (currentTime<= time){
            currentTime=System.currentTimeMillis();
        }
        System.out.println("token已失效");
    }
}
