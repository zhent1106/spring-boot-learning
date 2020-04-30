package com.soft1851.springboot.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/29
 **/
@RestController
public class TestController {
    @RequestMapping("/index")
    public  String simpleIndex(){
        return  "index";
    }
}