package com.soft1851.springboot.jwt.controller;

import com.soft1851.springboot.jwt.common.ResponseResult;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName AdminUserController
 * @Description TODO
 * @Author zhent
 * @Date 2020/4/15
 * @Version 1.0
 */
@Slf4j
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseResult adminLogin(String username, String password) {
        //模拟登录成功
        log.info(username, password);
        //模拟从数据库取得的用户ID和角色信息
        String userId = UUID.randomUUID().toString();
        String role = "commonAdmin";
        // 用userId和role来生成token，并指定过期时间
        Date expiresAt = new Date(System.currentTimeMillis() + 300L * 1000L);
        String token = JwtTokenUtil.getToken(userId, role, expiresAt);
        log.info("### 登录成功, token={} ###", token);
        //获取HttpServletResponse对象
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletResponse response = sra.getResponse();
        assert response != null;
        // 将token放在响应头返回，此处需在跨域配置中配置allowedHeaders和allowedExposedHeaders
        response.setHeader("Authorization", token);
        return ResponseResult.success();
    }

    @GetMapping("/permission")
    public ResponseResult getPerMissions() {
        log.info("### 查询当前角色的权限 ###");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("Authorization");
        String userRole = JwtTokenUtil.getUserRole(token);
//        String userRole=null;
//        int a=1/0;
        List<String> permissionsByRole = adminService.getPermissionsByRole(userRole);
        return ResponseResult.success(permissionsByRole);
    }
}