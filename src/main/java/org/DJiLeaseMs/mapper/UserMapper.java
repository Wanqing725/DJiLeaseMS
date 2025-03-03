package org.DJiLeaseMs.mapper;

import org.DJiLeaseMs.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User selectByUsername(String username);

    /**
     * 插入新用户
     */
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    void insert(User user);
}
