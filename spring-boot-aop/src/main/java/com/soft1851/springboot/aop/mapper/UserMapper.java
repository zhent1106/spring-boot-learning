package com.soft1851.springboot.aop.mapper;

import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/4/13
 **/
public interface UserMapper {

    @Select("SELECT * FROM t_user WHERE role_name=#{role_name}")
    User findUserByRoleName(String roleName) throws SQLException;
}