package com.example.demo.dao;

import com.example.demo.model.AdminInfo;
import org.apache.ibatis.annotations.Param;

public interface AdminInfoMapper {
    AdminInfo selectByPhone(@Param("phone") String phone);
}
