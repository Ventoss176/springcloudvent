package com.ventoss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/28
 * @description:
 */
@SpringBootApplication
//@ComponentScan(basePackages = {"com.ventoss.springcloud.service"})
@EnableFeignClients
//@EnableCircuitBreaker
@EnableHystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
