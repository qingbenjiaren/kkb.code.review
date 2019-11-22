package com.melo.mybatis.mapper;

import com.melo.pojo.User;

import java.util.List;

public interface UserMapper {
    public User selectOneById(int id);
    public User selectOne(User user);
    public List<User> selectAll();
}
