package com.xifeng.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Order {

    @TableId
    private Integer id;// 订单id
    private Integer pdtId;// 购买的商品id
    private String pdtName;// 商品名
    private Integer amount;// 数量
    private Integer totalMoney;//总金额
    private String payer;// 支付人
}
