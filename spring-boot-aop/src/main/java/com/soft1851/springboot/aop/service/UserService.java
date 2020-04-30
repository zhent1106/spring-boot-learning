package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
@Service
public interface UserService {
    /**
     * 根据用户角色查询用户是否存在
     * @param roleName
     * @return
     */
    User getUserByRoleName(String roleName) throws SQLException;
}
