package com.ventoss.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authoer:Ventoss
 * @createDate:2022/10/28
 * @description:
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为route-name的路由规则，
     * 当访问地址 http://localhost:9527/guonei时会自动转发到地址：http://news.baidu.com/guonei
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder)
    {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_ventoss", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();

    }

    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder builder1 = builder.routes();

        builder1.route("path_route_ventoss", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return builder1.build();

    }

}
