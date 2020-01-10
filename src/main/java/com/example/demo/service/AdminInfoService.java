package com.example.demo.service;

import com.example.demo.model.AdminInfo;

import java.util.List;

public interface AdminInfoService {
    List<AdminInfo> selectByPhone(String phone);
}
