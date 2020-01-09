package com.example.demo.service.impl;

import com.example.demo.dao.AdminInfoMapper;
import com.example.demo.model.AdminInfo;
import com.example.demo.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    public AdminInfo selectByPhone(String phone) {
        return adminInfoMapper.selectByPhone(phone);
    }
}
