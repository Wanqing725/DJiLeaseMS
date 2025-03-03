package org.DJiLeaseMs.service;

import org.DJiLeaseMs.entity.User;

public interface UserService {
    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户对象
     */
    User getUserByUsername(String username);

    /**
     * 添加新用户
     * @param user 用户对象
     */
    void addUser(User user);
}
