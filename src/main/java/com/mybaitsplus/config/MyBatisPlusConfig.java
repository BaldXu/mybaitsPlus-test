package com.mybaitsplus.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.mybaitsplus.mapper") //在主启动器上扫描mapper文件夹下所有的接口
@EnableTransactionManagement //自动管理事务
@Configuration //配置类

public class MyBatisPlusConfig {
    //注册乐观锁插件 （看官网啊别老百度
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    //逻辑删除 （3.1.1之后就不需要注册了
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
