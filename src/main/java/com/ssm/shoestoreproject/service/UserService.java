package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.UserInfo;
import com.ssm.shoestoreproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserInfo findByName(String userName){
        return userMapper.findByName(userName);
    }

    public UserInfo findUserById(Integer userId){
        return userMapper.findUserById(userId);
    }

    public UserInfo findByNameandPasswd(String name, String passwd){
        return userMapper.findByNameandPasswd(name,passwd);
    }

    public void addUser(UserInfo userInfo){
        userMapper.addUser(userInfo);
    }

    public int updateUserSave(Double userSave,Integer userId){
        return userMapper.updateUserSave(userSave,userId);
    }

    public int updateUserSave1(Double userSave,Integer userId){
        return userMapper.updateUserSave1(userSave,userId);
    }

    public Double getUserSave(Integer userId){
        return userMapper.getUserSave(userId);
    }

    public int updateUserAdd(Integer userId, String userAdd){
        return userMapper.updateUserAdd(userId,userAdd);
    }

}
