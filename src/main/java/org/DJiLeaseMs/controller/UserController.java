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
        if (dbUser == null) {
            return Result.error(MessageConstant.LOGIN_FAILED);
        }

        // 生成JWT令牌
        String token = JwtUtil.generateToken(user.getUsername());
        return Result.success(MessageConstant.LOGIN_SUCCESS, token);
    }
}
