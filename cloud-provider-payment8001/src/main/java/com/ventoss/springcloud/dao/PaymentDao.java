package com.ventoss.springcloud.dao;

import com.ventoss.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/20
 * @description:
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
