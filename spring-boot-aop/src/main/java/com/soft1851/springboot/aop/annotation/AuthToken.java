package com.soft1851.springboot.aop.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {
    /**
     * 访问接口所需要的身份，默认为可，登录即可访问，可以定义多个
     * @return String[]
     */
    String[] role_name()  default "";

}
