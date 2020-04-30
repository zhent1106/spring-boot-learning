package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName SysPermission
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Data
@Builder
public class SysPermission {
    private Integer pId;
    private Integer parentId;
    private String pName;
    private Integer type;
    private String icon;
    private String path;
    private String ex1;
    private Integer ex2;
}