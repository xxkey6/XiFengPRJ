package com.xifeng.service;


import com.xifeng.domain.entity.Product;

public interface ProductManipulationService {

    // 添加
    boolean add(Product product);

    // 修改(购买功能)
    boolean update(Product product);

    // 按id删除
    boolean delete(Integer id);
}
