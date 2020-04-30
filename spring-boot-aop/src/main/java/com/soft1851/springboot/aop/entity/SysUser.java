package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName SysUser
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Data
@Builder
public class SysUser {
    private Integer userId;
    private String userName;
    private String password;
    private String avatar;
    private String realName;
    private Date createTime;
}