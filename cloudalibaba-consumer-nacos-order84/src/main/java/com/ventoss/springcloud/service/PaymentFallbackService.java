package com.ventoss.springcloud.service;

import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/9
 * @description:
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));

    }
}
