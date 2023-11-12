package com.xifeng.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.domain.Code;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.Order;
import com.xifeng.domain.entity.Product;
import com.xifeng.domain.entity.User;
import com.xifeng.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShoppingController {

    @Autowired
    private ProductQueryService productQueryService;
    @Autowired
    private ProductManipulationService productManipulationService;

    @Autowired
    private OrderQueryService orderQueryService;

    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private UserManipulationService userManipulationService;
    @Autowired
    private OrderManipulationService orderManipulationService;

    @PostMapping("/summit")
    public Result summitOrder(Integer pdtId, Integer amount, String username){
        // 获取当前商品并减少数量
        Product pdt = productQueryService.getOne(pdtId);
        pdt.setAmount(pdt.getAmount() - amount);
        // 封装订单信息
        Order order = new Order( null, pdtId, pdt.getName(), amount,
                (int) (pdt.getUnitPrice()*amount), username);
        // 获取当前用户 并判断余额是否足够
        User prUser = userQueryService.getOne(username);
        prUser.setBalance(prUser.getBalance() - order.getTotalMoney());
        if (prUser.getBalance() < 0){
            return new Result(false, Code.FAIL, null, "余额不足!");
        }else {// 提交一系列事务
            try {
                orderManipulationService.add(order);
                productManipulationService.update(pdt);
                userManipulationService.update(prUser);
            }catch (Exception e){
                e.printStackTrace();
                return new Result(false, Code.FAIL, null, "购买失败");
            }
            return new Result(true, Code.SUCCESS, null, "购买成功");
        }
    }
}
