package com.ventoss.springcloud.service;

import com.ventoss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/20
 * @description:
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
