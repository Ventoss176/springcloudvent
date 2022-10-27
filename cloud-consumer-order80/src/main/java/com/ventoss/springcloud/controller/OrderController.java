package com.ventoss.springcloud.controller;

import com.ventoss.springcloud.entities.CommonResult;
import com.ventoss.springcloud.entities.Payment;
import com.ventoss.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/21
 * @description:
 */
@RestController
@Slf4j
public class OrderController {

//    private static final String PaymentSrv_URL = "http://localhost:8001";
    private static final String PAYMENTSRV_NAME = "CLOUD-PAYMENT-SERVICE";
    private static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private LoadBalancer loadBalancer;


    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PaymentSrv_URL+"/payment/create", payment,
                CommonResult.class);
    }

    @GetMapping("/consumer/payment/createentity")
    public CommonResult createEntity(Payment payment){
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PaymentSrv_URL + "/payment/create", payment,
                CommonResult.class);
        return commonResultResponseEntity.getBody();
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PaymentSrv_URL+"/payment/get/"+id,
                CommonResult.class,id);
    }

    @GetMapping("/consumer/payment/getentity/{id}")
    public CommonResult getPaymentEntityById(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PaymentSrv_URL + "/payment/get/" + id,
                CommonResult.class, id);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            log.info(forEntity.getStatusCode().toString() + forEntity.getHeaders());
            return forEntity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }

    }


    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances =
                discoveryClient.getInstances(PAYMENTSRV_NAME);
        if(instances == null || instances.size() <= 0){

            return null;
        }

        ServiceInstance instances1 = loadBalancer.instances(instances);
        URI uri = instances1.getUri();

        return restTemplate.getForObject(uri + "/payment/lb",String.class);

    }
}
