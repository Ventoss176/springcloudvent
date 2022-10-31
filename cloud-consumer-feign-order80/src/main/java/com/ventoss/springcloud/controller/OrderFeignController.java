package com.ventoss.springcloud.controller;

import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.entities.Payment;
import com.ventoss.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/27
 * @description:
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){

        return paymentFeignService.getPaymentById(id);

    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String getTimeout(){

        return paymentFeignService.getTimeout();
    }
}
