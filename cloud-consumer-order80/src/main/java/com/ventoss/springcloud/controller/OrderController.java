package com.ventoss.springcloud.controller;

import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/21
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

//    private static final String PaymentSrv_URL = "http://localhost:8001";
    private static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PaymentSrv_URL+"/payment/create", payment,
                CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PaymentSrv_URL+"/payment/get/"+id,
                CommonResult.class,id);
    }
}
