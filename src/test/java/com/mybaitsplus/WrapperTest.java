package com.mybaitsplus;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybaitsplus.mapper.UserMapper;
import com.mybaitsplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;//继承了basemapper，所有的方法都来自父类，当然可以自己编写扩展方法

//https://www.jianshu.com/p/c5537559ae3a yWrapper的常用条件查询

    //查询
    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")//查询名字不为空的用户
                .ge("age",22);//并且年龄大于等于22的用户
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void contextLoads1() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .between("age",20,22)//年龄在20到22的用户
                .or().eq("age",12223);//或者年龄为12223
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
    //模糊查询 + 连接查询
    @Test
    void contextLoads2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .like("name","D")//查询名字里带D的.要注意的是这个是不区分大小写的
                .or().likeRight("name","J")//或者名字开头是J
                .or().notLike("age",2);//或者年龄中不包含2的值

        userMapper
                .selectList(wrapper)
                .forEach(System.out::println);

        Integer count = userMapper.selectCount(wrapper);
        System.out.println("查询出来的结果总数是："+count);

    }

    //拼接查询 前面的OR也是拼接，但是在这里进一步
    @Test
    void contextLoads3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .inSql("id","select id from user where id<3");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }

    //排序
    @Test
    void contextLoads4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .orderByDesc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }
}
