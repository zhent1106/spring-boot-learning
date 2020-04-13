package com.soft1851.springboot.aop.service;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
public interface UserService {
    void  selectAdmin(String authToken);
}
