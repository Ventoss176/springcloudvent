package com.ventoss.springcloud;

import com.ventoss.myrule.MyNewRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/21
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
//大写
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE", configuration = MyNewRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
