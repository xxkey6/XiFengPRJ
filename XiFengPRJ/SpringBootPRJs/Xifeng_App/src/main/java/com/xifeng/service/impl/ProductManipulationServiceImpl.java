package com.xifeng.service.impl;

import com.xifeng.dao.ProductMapper;
import com.xifeng.domain.entity.Product;
import com.xifeng.service.ProductManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManipulationServiceImpl implements ProductManipulationService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
        return productMapper.insert(product) == 1;
    }

    @Override
    public boolean update(Product product) {
        return productMapper.updateById(product) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return productMapper.deleteById(id) == 1;
    }
}
