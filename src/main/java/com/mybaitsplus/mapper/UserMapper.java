package com.mybaitsplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybaitsplus.pojo.User;
import org.springframework.stereotype.Repository;

//使用了mybaitsplus不用写xml，只要在对应的mapper上继承基本的类BaseMapper
@Repository//其实没有这个都可以，写一个这个代表这个是持久层
public interface UserMapper extends BaseMapper<User> {
    //到这里其实所有的CRUD操作都写完了，不需要配置一大堆文件了


}
