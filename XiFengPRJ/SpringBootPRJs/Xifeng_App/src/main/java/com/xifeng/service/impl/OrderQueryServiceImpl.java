package com.xifeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.dao.OrderMapper;
import com.xifeng.domain.entity.Order;
import com.xifeng.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void getMine(Page<Order> page, String username) {
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.eq("payer", username);
        orderMapper.selectPage(page, wrapper);
    }
}
