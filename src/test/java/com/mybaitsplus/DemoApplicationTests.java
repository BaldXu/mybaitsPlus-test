package com.mybaitsplus;

import com.mybaitsplus.mapper.UserMapper;
import com.mybaitsplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;//继承了basemapper，所有的方法都来自父类，当然可以自己编写扩展方法

    @Test
    void contextLoads() {
        //查询全部用户，这里的参数是一个wrapper，条件构造器，这里先不用
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
