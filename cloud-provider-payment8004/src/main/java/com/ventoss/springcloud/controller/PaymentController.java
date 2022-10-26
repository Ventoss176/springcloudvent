package com.ventoss.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/26
 * @description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    private String paymentzk(){

        return "springcloud with zookeeper: " +
                " "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
