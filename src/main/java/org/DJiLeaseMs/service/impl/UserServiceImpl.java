package org.DJiLeaseMs.service.impl;

import org.DJiLeaseMs.entity.User;
import org.DJiLeaseMs.excption.BaseException;
import org.DJiLeaseMs.mapper.UserMapper;
import org.DJiLeaseMs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        // 参数校验
        if (username == null || username.trim().isEmpty()) {
            throw new BaseException("用户名不能为空");
        }
        return userMapper.selectByUsername(username);
    }

    @Override
    public void addUser(User user) {
        // 参数校验
        if (user == null) {
            throw new BaseException("用户信息不能为空");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new BaseException("用户名不能为空");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new BaseException("密码不能为空");
        }

        // 检查用户名是否已存在
        User existUser = getUserByUsername(user.getUsername());
        if (existUser != null) {
            throw new BaseException("用户名已存在");
        }

        // 插入用户数据
        userMapper.insert(user);
    }
}
