package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Data
@Builder
public class SysRole {
    private Integer roleId;
    private String roleName;
    private String description;
}