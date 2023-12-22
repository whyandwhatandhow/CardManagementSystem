package com.digital.service.impl;

import com.digital.dao.UserMapper;
import com.digital.entity.User;
import com.digital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

}
