package com.xifeng.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("users")
//用户类
public class User {

    @TableId
    private Integer id;
    private String username;
    private String password;
    private String role;
    private Float balance;

}
