package com.ventoss.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @authoer:Ventoss
 * @createDate:2022/11/11
 * @description:
 */
@Configuration
@MapperScan({"com.ventoss.springcloud.dao"})
public class MyBatisConfig {
}

