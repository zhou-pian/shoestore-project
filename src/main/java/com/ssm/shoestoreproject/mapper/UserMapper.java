package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper {

    public UserInfo findByName(String userName);

    public UserInfo findUserById(Integer userId);

    public UserInfo findByNameandPasswd(@Param("name") String name,@Param("passwd") String passwd);

    public void addUser(UserInfo userInfo);

    public int updateUserSave(Double userSave,Integer userId);
    public int updateUserSave1(Double userSave,Integer userId);

    public Double getUserSave(Integer userId);

    //改地址
    public  int updateUserAdd(@Param("userId")Integer userId, @Param("userAdd") String userAdd);
}
