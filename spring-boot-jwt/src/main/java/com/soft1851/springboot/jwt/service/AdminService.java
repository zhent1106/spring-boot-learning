package com.soft1851.springboot.jwt.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName AdminService
 * @Description 模拟Admin服务
 * @Author zhent
 * @Date 2020/4/15
 * @Version 1.0
 */
@Service
public class AdminService {

    /**
     * 根据role获取权限
     *
     * @param role
     * @return List<String>
     */
    public List<String> getPermissionsByRole(String role) {
        Map<String, List<String>> map = new TreeMap<>();
        String[] admins = {"专辑管理", "歌曲管理"};
        String[] superAdmins = {"权限管理", "系统设置"};
        String[] commonAdmin={"歌单管理","积分管理"};
        map.put("admin", Arrays.asList(admins));
        map.put("superAdmin", Arrays.asList(superAdmins));
        map.put("commonAdmin",Arrays.asList(commonAdmin));
        return map.get(role);
    }

    public boolean checkRole(String role) {
        if ("admin".equals(role) || ("superAdmin".equals(role) ||("commonAdmin").equals(role))) {
            return true;
        } else {
            return false;
        }
    }
}
