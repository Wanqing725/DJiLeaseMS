package org.DJiLeaseMs.controller;

import org.DJiLeaseMs.common.constant.MessageConstant;
import org.DJiLeaseMs.common.result.Result;
import org.DJiLeaseMs.entity.User;
import org.DJiLeaseMs.service.UserService;
import org.DJiLeaseMs.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user) {
        // 验证用户名和密码
        User dbUser = userService.getUserByUsername(user.getUsername());
        System.out.println(dbUser);
        if (dbUser == null || !user.getPassword().equals(dbUser.getPassword())) {
            return Result.error(MessageConstant.LOGIN_FAILED);
        }

        // 生成JWT令牌
        String token = JwtUtil.generateToken(user.getUsername());
        return Result.success(MessageConstant.LOGIN_SUCCESS, token);
    }
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        // 验证用户名是否已存在
        User existUser = userService.getUserByUsername(user.getUsername());
        if (existUser != null) {
            return Result.error("用户名已存在");
        }

        // 验证必填字段
        if (user.getUsername() == null || user.getUsername().trim().isEmpty() ||
            user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return Result.error("用户名和密码不能为空");
        }

        // 保存用户信息
        userService.addUser(user);
        return Result.success(MessageConstant.OPERATE_SUCCESS);
    }
}
