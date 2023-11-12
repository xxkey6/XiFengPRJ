package com.xifeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xifeng.domain.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
}
