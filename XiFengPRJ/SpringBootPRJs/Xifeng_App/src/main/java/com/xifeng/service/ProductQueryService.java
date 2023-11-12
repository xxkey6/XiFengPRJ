package com.xifeng.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.domain.Condition;
import com.xifeng.domain.entity.Product;

import java.util.List;

public interface ProductQueryService {

    // 按id查询
    Product getOne(Integer id);

    // 查询所有
    List<Product> getAll();

    // 分类分页查询
    Page<Product> getPageWithType(Page<Product> page, String type);

    // 分页条件查询
    void getPageWithCondition(Page<Product> page, Condition condition);


}
