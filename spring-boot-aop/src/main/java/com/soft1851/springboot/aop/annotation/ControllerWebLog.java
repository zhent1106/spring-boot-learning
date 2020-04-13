package com.soft1851.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @ClassName ControllerWebLog
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/9
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 调用接口名称
     * @return
     */
    String name();

    /**
     * 该日志是否需要持久化存储
     * @return
     */
    boolean isSaved() default  false;

}
