package com.xifeng.service.impl;

import com.xifeng.dao.OrderMapper;
import com.xifeng.domain.entity.Order;
import com.xifeng.service.OrderManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManipulationServiceImpl implements OrderManipulationService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean add(Order order) {
        return orderMapper.insert(order) == 1;
    }
}
