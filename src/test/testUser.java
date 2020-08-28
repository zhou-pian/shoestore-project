package com.ssm.shoestoreproject.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zp.domin.UserInfo;
import zp.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;

public class testUser {

    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        UserMapper dao = session.getMapper(UserMapper.class);
        //查询所有
        UserInfo userInfo = dao.findByName("熊二");
        System.out.println(userInfo);
        //关闭资源
        session.close();
        in.close();
    }
    @Test
    public void run2() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        UserMapper dao = session.getMapper(UserMapper.class);
        //查询所有
        UserInfo userInfo = new UserInfo("aaa","44444","11155558774","beii");
        dao.addUser(userInfo);
        System.out.println(userInfo);
        //提交事务
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
