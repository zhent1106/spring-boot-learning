package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName WebLogAspect
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/9
 **/

@Aspect
@Component
@Order(100)
@Slf4j
public class WebLogAspect {
    /**
     * 定义切点
     */
@Pointcut("execution(public *  com.soft1851.springboot.aop.controller..*.*(..))")
    public  void webLog(){

    }
@Before(value = "webLog() && @annotation(controllerWebLog)")
    public  void  doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog){
    //接受请求
    RequestAttributes at = RequestContextHolder.getRequestAttributes();
    ServletRequestAttributes sra= (ServletRequestAttributes) at;
    assert  sra!=null;
    HttpServletRequest request=sra.getRequest();
    log.info("请求URL"+request.getRequestURI());
    log.info("请求方法名："+controllerWebLog.name());
    log.info("是否需要持久化该条日志"+controllerWebLog.isSaved());
    log.info("AOP拦截获得参数:"+ Arrays.toString(joinPoint.getArgs()));
}

}