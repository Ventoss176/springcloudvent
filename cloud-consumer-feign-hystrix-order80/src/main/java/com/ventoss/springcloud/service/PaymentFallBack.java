package com.ventoss.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/28
 * @description:
 */
@Component
public class PaymentFallBack implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK服务调用失败，提示来自：cloud-consumer-feign-hystrix-order80";

    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut服务调用失败，提示来自：cloud-consumer-feign-hystrix-order80";

    }
}
