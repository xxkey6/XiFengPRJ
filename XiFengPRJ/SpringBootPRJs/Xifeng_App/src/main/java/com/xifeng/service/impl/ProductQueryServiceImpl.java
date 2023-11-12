package com.xifeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.dao.ProductMapper;
import com.xifeng.domain.Condition;
import com.xifeng.domain.entity.Product;
import com.xifeng.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getOne(Integer id) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return productMapper.selectOne(wrapper);
    }

    @Override
    public List<Product> getAll() {
        return productMapper.selectList(null);
    }

    @Override
    public Page<Product> getPageWithType(Page<Product> page, String type) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("type", type);

        return productMapper.selectPage(page, wrapper);
    }

    @Override
    public void getPageWithCondition(Page<Product> page, Condition condition) {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        String type = condition.getType();
        Integer minPrice = condition.getMinPrice();
        Integer maxPrice = condition.getMaxPrice();
        String name = condition.getName();
        // 按类型查询
        if (type != null){
            wrapper.eq("type", type);
        }
        // 按价格区间查询
        if (minPrice != null && maxPrice != null && minPrice >= 0 && maxPrice > minPrice){
            wrapper.ge("unit_price", minPrice);
            wrapper.le("unit_price", maxPrice);
        }

        if (name != null){
            wrapper.like("name", name);
        }


        productMapper.selectPage(page, wrapper);
    }
}
