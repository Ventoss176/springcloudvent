package com.ventoss.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/26
 * @description:
 */
@Configuration
public class MyNewRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
