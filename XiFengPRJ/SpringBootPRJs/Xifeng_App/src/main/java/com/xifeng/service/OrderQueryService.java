package com.xifeng.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.domain.entity.Order;

public interface OrderQueryService {

    void getMine(Page<Order> page, String username);
}
