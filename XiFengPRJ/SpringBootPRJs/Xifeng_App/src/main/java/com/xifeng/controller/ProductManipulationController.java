package com.xifeng.controller;

import com.xifeng.domain.Code;
import com.xifeng.domain.Result;
import com.xifeng.domain.entity.Product;
import com.xifeng.service.ProductManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdts")
public class ProductManipulationController {

    @Autowired
    private ProductManipulationService service;

    @PostMapping("/add")
    public Result add(Product product){
        if (service.add(product)){
            return new Result(true, Code.SUCCESS, null, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

    @PutMapping("/update")
    public Result update(Product product){
        if (service.update(product)){
            return new Result(true, Code.SUCCESS, null, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }

    @DeleteMapping("/delete")
    public Result delete(Integer pdtId){
        if (service.delete(pdtId)){
            return new Result(true, Code.SUCCESS, null, "成功");
        }else {
            return new Result(false, Code.FAIL, null, "失败");
        }
    }


}
