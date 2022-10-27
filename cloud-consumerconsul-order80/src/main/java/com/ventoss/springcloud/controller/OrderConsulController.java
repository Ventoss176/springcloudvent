package com.ventoss.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/26
 * @description:
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL =
            "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
        log.info("消费者调用支付服务(consule)--->result:" + result);
        return result;
    }

}
