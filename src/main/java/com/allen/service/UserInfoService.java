package com.allen.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allen.dao.UserInfoMapper;
import com.allen.po.UserInfo;

@Service
public class UserInfoService {
    
    @Resource
    private UserInfoMapper userInfoMapper;
    
    public UserInfo findById(Long id){
        return this.userInfoMapper.selectByPrimaryKey(id);
    }
    
    public void add(UserInfo userInfo){
        int result=this.userInfoMapper.insertSelective(userInfo);
        if(result==0){
            throw new RuntimeException("新增失败");
        }
    }
    
    @Transactional
    public void update(UserInfo userInfo){
        if(userInfo.getId()==null){
            throw new RuntimeException("id不能为空!");
        }
        int result=this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(result==0){
            throw new RuntimeException("更新失败");
        }
    }

}
