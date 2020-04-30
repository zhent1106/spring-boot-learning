package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName RolePermission
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Data
@Builder
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
}