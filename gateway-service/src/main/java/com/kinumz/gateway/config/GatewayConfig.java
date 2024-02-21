package com.kinumz.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
             .route("auth-service", r -> r.path("/api/v1/auth/**")
                .uri("lb://AUTH-SERVICE"))
            .route("customer-service", r -> r.path("/api/v1/customers/**")
                .filters(f -> f.filter(filter))
                .uri("lb://CUSTOMER-SERVICE"))
            .build();

    }

}
