package com.digital.dao;

import com.digital.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    void addUser(User user);//注册
    User selectUserByUsername(@Param("username") String username);//登录
    void updateUser(User user);//改密码

}
