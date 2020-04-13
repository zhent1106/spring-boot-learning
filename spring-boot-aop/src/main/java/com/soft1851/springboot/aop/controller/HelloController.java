package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/9
 **/
@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class HelloController {
    @RequestMapping(value = "hello")
    @ControllerWebLog(name = "hello",isSaved =true)
    public  String  getHello(String arg1,int arg2){
        log.info("控制层获得的参数："+arg1);
        log.info("控制层获得的参数："+arg2);
        return "Hello spring boot aop";

    }
}