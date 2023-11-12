package com.xifeng.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xifeng.domain.Code;
import com.xifeng.domain.Condition;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.Product;
import com.xifeng.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pdts")
public class ProductQueryController {

    @Autowired
    private ProductQueryService service;

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        Product data = service.getOne(id);
        if (data != null){
            return new Result(true, Code.SUCCESS, data, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

    @GetMapping
    public Result getAll(){
        List<Product> pdts = service.getAll();
        if (pdts != null){
            return new Result(true, Code.SUCCESS, pdts, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

//    @GetMapping
//    public Result getPageWithType(Integer current, Integer size, String type){
//        Page<Product> page = new Page<>(current, size);
//        Page<Product> data = service.getPageWithType(page, type);
//        if (data != null){
//            return new Result(true, Code.SUCCESS, data, "成功");
//        }else {
//            return new Result(false, Code.FAIL, null, "失败");
//        }
//    }

    @GetMapping("/page")
    public Result getPageWithCondition(Condition condition, Integer current, Integer size){

        Page<Product> page = new Page<>(current, size);

        service.getPageWithCondition(page, condition);

        if (page.getRecords() != null){
            return new Result(true, Code.SUCCESS, page, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }
}
