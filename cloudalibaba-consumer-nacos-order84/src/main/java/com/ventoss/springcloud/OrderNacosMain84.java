package com.ventoss.springcloud;

import org.apache.commons.io.filefilter.AgeFileFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/8
 * @description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OrderNacosMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain84.class, args);
    }
}
