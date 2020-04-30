package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Builder
@Data
public class User {
   private Integer id;
   private String roleName;
   private  String account;
   private  String password;
}