package com.example.demo.controller;

import com.example.demo.core.ret.RetResponse;
import com.example.demo.core.ret.RetResult;
import com.example.demo.model.AdminInfo;
import com.example.demo.service.AdminInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("adminInfo")
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;

    @RequestMapping("/selectByPhone")
    public RetResult<List<AdminInfo>> selectByPhone(@RequestParam(defaultValue = "") String phone) {
        List<AdminInfo> adminInfo = adminInfoService.selectByPhone(phone);
        return RetResponse.makeOKRsp(adminInfo);
    }
}
