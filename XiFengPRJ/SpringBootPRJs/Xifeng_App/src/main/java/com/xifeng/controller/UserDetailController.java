package com.xifeng.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.domain.Code;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.Order;
import com.xifeng.domain.entity.User;
import com.xifeng.service.OrderQueryService;
import com.xifeng.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserDetailController {

    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private OrderQueryService orderQueryService;

    @GetMapping("/details")
    public Result checkDetails(String username){
        User user = userQueryService.getOne(username);
        if (user != null){
            return new Result(true, Code.SUCCESS, user, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

    @GetMapping("/orders")
    public Result checkMyOrder(Integer current, Integer size, String username){
        Page<Order> page = new Page<>(current, size);
        orderQueryService.getMine(page, username);

        if (page.getRecords() != null){
            return new Result(true, Code.SUCCESS, page, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }
}
