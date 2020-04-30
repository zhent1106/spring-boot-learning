package com.soft1851.springboot.aop.service.Impl;

import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
public class UserServiceImpl implements UserService {
@Resource
private UserMapper userMapper;
    @Override
    public User getUserByRoleName(String roleName) throws SQLException {
        return userMapper.findUserByRoleName(roleName);
    }
}