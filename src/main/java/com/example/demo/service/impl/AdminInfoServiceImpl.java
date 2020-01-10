package com.example.demo.service.impl;

import com.example.demo.dao.AdminInfoMapper;
import com.example.demo.model.AdminInfo;
import com.example.demo.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Override
    public List<AdminInfo> selectByPhone(String phone) {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setPhone(phone);
        return adminInfoMapper.selectByCondition(adminInfo);
    }
}
