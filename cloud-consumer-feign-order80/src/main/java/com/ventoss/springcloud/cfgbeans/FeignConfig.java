package com.ventoss.springcloud.cfgbeans;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/27
 * @description:
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignloggerlevel(){

        return Logger.Level.FULL;
    }
}
