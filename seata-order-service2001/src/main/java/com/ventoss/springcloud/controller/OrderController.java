package com.ventoss.springcloud.controller;

import com.ventoss.springcloud.domain.CommonResult;
import com.ventoss.springcloud.domain.Order;
import com.ventoss.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/11
 * @description:
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public CommonResult create( Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功!");
    }
}
