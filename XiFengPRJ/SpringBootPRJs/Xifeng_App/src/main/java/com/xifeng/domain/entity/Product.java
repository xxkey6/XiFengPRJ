package com.xifeng.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("products")
public class Product {

    @TableId
    private Integer id;
    private String name;
    private String type;
    private Float unitPrice;// 单价
    private Integer amount;

}
