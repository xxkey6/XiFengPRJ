package com.xifeng.controller;

import com.xifeng.domain.Code;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.User;
import com.xifeng.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserQueryController {

    @Autowired
    private UserQueryService service;

    @GetMapping("/one")
    public Result getOne(String username){
        User user = service.getOne(username);
        if (user != null){
            return new Result(true, Code.SUCCESS, user, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

    @GetMapping
    public Result getAll(){
        List<User> users = service.getAll();
        if (users != null){
            return new Result(true, Code.SUCCESS, users, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }
}
