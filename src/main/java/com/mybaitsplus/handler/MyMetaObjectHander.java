package com.mybaitsplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j //日志
@Component  //要被springboot识别,所以要将处理器加到IOC容器中
//自动以实现类（看mybaitsplus的官网可以在插件扩展那里看到
public class MyMetaObjectHander implements MetaObjectHandler {
    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill......");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill......");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
