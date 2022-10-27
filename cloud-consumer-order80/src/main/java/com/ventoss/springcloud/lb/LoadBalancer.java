package com.ventoss.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/27
 * @description:
 */
//@Component
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
