package com.mybaitsplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO) //自增
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version//乐观锁注解
    private Integer version;

    @TableLogic //逻辑删除
    private Integer deleted;
    // 要注意的是 3.1.1开始就不用再config哪里注册Bean了，现在官网也直接不说了 但是我现在还是就版本，所以要注册
    //但是日志还是要配置的

    @TableField(fill = FieldFill.INSERT)//在插入的时候自动填充
    private Date createTime;
    @TableField(fill = FieldFill.INSERT)
    private Date updateTime;


}
