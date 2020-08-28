package com.ssm.shoestoreproject.service;

import com.ssm.shoestoreproject.domin.AdminInfo;
import com.ssm.shoestoreproject.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public AdminInfo findByName(String adminName){
        return adminMapper.findByName(adminName);
    }

    public AdminInfo findByNameandPasswd(String name,String passwd){
        return adminMapper.findByNameandPasswd(name,passwd);
    }

}
