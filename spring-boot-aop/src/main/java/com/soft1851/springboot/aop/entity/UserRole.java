package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Data
@Builder
public class UserRole {
   private Integer id;
   private  String userId;
   private  Integer roleId;
}