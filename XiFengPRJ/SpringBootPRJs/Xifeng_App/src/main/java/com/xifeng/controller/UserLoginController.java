package com.xifeng.controller;

import com.xifeng.domain.Code;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.User;
import com.xifeng.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserLoginController {

    @Autowired
    private UserQueryService service;

    @PostMapping("/login")
    public Result login(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getRole());
        User prUser = service.getOne(user.getUsername());

        if (user.getPassword().equals(prUser.getPassword())){
            if (!Objects.equals(user.getRole(), prUser.getRole())){
                return new Result(false, Code.FAIL, null, "用户身份不匹配");
            }else{
                return new Result(true, Code.SUCCESS, prUser, "成功");
            }
        }else {
            return new Result(false, Code.FAIL, null, "密码错误");
        }
    }
}
