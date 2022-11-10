package com.ventoss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/3
 * @description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMainAli9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMainAli9001.class, args);
    }
}
