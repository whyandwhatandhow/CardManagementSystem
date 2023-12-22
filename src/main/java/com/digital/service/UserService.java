package com.digital.service;

import com.digital.entity.User;

public interface UserService {
    void addUser(User user);//注册
    User selectUserByUsername(String username);//登录
    void updateUser(User user);//改密码
}
