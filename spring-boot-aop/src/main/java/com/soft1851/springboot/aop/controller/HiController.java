package com.soft1851.springboot.aop.controller;
import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HiController
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/10
 **/
@RestController
public class HiController {

/**
 * 提供hello方法为待测试的业务接口
 */
    @RequestMapping(value = "/hello")
    @ControllerWebLog(name = "hello",isSaved =true)
  public String hello(String name){
        return  "hello" + name;
    }

}