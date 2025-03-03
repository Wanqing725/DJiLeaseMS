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
}
