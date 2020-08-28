package com.ssm.shoestoreproject.mapper;

import com.ssm.shoestoreproject.domin.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
public interface AdminMapper {

    public AdminInfo findByName(String name);

    public AdminInfo findByNameandPasswd(@Param("name") String name,@Param("passwd") String passwd);
}
