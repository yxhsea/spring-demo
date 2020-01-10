package com.example.demo.controller;

import com.example.demo.core.ret.RetResponse;
import com.example.demo.core.ret.RetResult;
import com.example.demo.core.ret.ServiceException;
import com.example.demo.model.UserInfo;
import com.example.demo.service.UserInfoService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoController")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/hello")
    public String hello() {
        return "hello Spring boot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "query")})
    @PostMapping("/selectById")
    public RetResult<UserInfo> selectById(@RequestParam Integer id) {
        UserInfo userInfo = userInfoService.selectById(id);
        if (userInfo == null) {
            throw new ServiceException("not found user");
        }
        return RetResponse.makeOKRsp(userInfo);
    }

    @PostMapping("/testException")
    public RetResult<UserInfo> testException(Integer id) {
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public RetResult<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageInfo<UserInfo> pageInfo = userInfoService.selectAll(page, size);
        return RetResponse.makeOKRsp(pageInfo);
    }

    @PostMapping("/create_user")
    public <T> RetResult<T> createUser(
        @RequestParam(defaultValue = "0") String id,
        @RequestParam(defaultValue = "") String userName,
        @RequestParam(defaultValue = "") String password
    ) {
        try {
            userInfoService.createUser(id, userName, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return RetResponse.makeErrRsp(e.getMessage());
        }

        return RetResponse.makeOKRsp();
    }

    @PostMapping("/update_user")
    public <T> RetResult<T> updateUser(
        @RequestParam(defaultValue = "") String id,
        @RequestParam(defaultValue = "", required = true) String userName,
        @RequestParam(defaultValue = "") String password
    ) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfoService.updateUser(userInfo);

        return RetResponse.makeOKRsp();
    }

    @PostMapping("/delete_user")
    public <T> RetResult<T> deleteUser(
        @RequestParam(defaultValue = "") String id
    ) {
        Integer row = userInfoService.deleteUser(id);
        if (row.equals(0)) {
            return RetResponse.makeErrRsp("delete failure");
        }

        return RetResponse.makeOKRsp();
    }
}
