package com.example.demo.service;

import com.example.demo.model.AdminInfo;

public interface AdminInfoService {
    AdminInfo selectByPhone(String phone);
}
