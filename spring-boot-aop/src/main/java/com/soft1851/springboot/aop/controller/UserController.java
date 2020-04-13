package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@RestController
@Slf4j
public class UserController {
    /**
     *
     * @param name
     * @return
     */
    @GetMapping(value = "hello")
    public String hello(String name){
        log.info("hello()方法无需鉴权，也无需认证，当前用户名："+ name);
        return "hello 方法访问成功";
    }

    /**
     * 需要鉴权，此时方法需要家注解，但是不需要传角色
     * @param name
     * @return
     */
    @GetMapping(value = "user")
    @AuthToken
    public String user(String name){
        return "user()方法访问成功";
    }

    /**
     * 需要鉴权，此时方法需要加注解，但是需要传多个角色
     * 如果需要更复杂的逻辑操作，建议使用spring Security Apache Shhi
     * @param name
     * @return
     */
    @GetMapping(value = "admin")
    @AuthToken(role_name = {"admin","Admin"})
    public String admin(String name){
        log.info("admin()方法需要鉴权，需要认证，当前用户名："+ name);
        return "admin()方法访问成功";
    }

}