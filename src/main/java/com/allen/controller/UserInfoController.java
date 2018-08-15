package com.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.model.ResultBean;
import com.allen.po.UserInfo;
import com.allen.service.UserInfoService;

@RestController
public class UserInfoController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    @RequestMapping(value="/user/info")
    public ResultBean<UserInfo> getUserInfo(@RequestParam(required=true) Long id){
        return new ResultBean<UserInfo>(this.userInfoService.findById(id));
    }
    
    @PostMapping(value="/user/add")
    public ResultBean<Long> addUser(@RequestBody UserInfo userInfo){
        this.userInfoService.add(userInfo);
        return new ResultBean<>();
    }
    
    @PostMapping(value="/user/update")
    public ResultBean<Long> update(@RequestBody UserInfo userInfo){
        this.userInfoService.update(userInfo);
        return new ResultBean<>();
    }

}
