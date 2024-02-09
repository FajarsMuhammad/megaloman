package com.kinumz.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("users", r -> r.path("/users/**")
                .filters(f -> f.filter(filter))
                .uri("lb://users"))
            .route("authentications", r -> r.path("/auth/**")
                .filters(f -> f.filter(filter))
                .uri("lb://authentications"))
            .build();

    }

}
