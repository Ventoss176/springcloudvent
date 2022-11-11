package com.ventoss.springcloud.controller;

import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.entities.Payment;
import com.ventoss.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/20
 * @description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;



    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int age = 10/2;
        int result = paymentService.create(payment);
        log.info("********插入返回结果:" + result);

        if(result > 0){
            return new CommonResult(200,"插入数据库成功 + severPort:" + serverPort,result);

        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果:{}",payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功 + serverPort:" + serverPort ,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }


    @GetMapping(value = "/testfilter")
    public String getfilter(HttpServletRequest request, String NewParam,String name) {

        return serverPort + request.getHeader("NewHeader") + NewParam + name;
    }

    @GetMapping(value = "/payment/timeout")
    public String getTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }



    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to ventoss，O(∩_∩)O哈哈~";
    }

}
