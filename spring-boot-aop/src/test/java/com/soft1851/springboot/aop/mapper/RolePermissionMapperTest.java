package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.SpringBootAopApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpringBootAopApplication.class)

class RolePermissionMapperTest {
    @Resource
    private  RolePermissionMapper rolePermissionMapper;

    @Test
    void getRoleById() {
        System.out.println(rolePermissionMapper.getRoleById(1));
    }
}