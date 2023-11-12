package com.xifeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xifeng.domain.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
