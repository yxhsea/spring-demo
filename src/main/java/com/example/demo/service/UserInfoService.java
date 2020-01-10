package com.example.demo.service;

import com.example.demo.model.UserInfo;
import com.github.pagehelper.PageInfo;

public interface UserInfoService {
    UserInfo selectById(Integer id);
    PageInfo<UserInfo> selectAll(Integer page, Integer size);
    void createUser(String id, String userName, String password);
    void updateUser(UserInfo userInfo);
    Integer deleteUser(String id);
}
