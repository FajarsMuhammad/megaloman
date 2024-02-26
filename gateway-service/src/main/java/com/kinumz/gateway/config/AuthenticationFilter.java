package com.kinumz.gateway.config;

import com.kinumz.gateway.service.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RefreshScope
@Component
@RequiredArgsConstructor
public class AuthenticationFilter implements GatewayFilter {

    private final RouteValidator validator;

    private final JwtUtils jwtUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (validator.isSecured.test(request)) {
            if (authMissing(request)) {
                return onError(exchange, HttpStatus.UNAUTHORIZED);
            }

            String token = request.getHeaders().getOrEmpty("Authorization").get(0);
            if (StringUtils.isNotEmpty(token) && StringUtils.startsWith(token, "Bearer ")) {
                token = token.substring(7);
            }

            if (jwtUtils.isExpired(token)) {
                return onError(exchange, HttpStatus.UNAUTHORIZED);
            }
            //pass header using @RequestHeader on controller
            request = exchange.getRequest()
                .mutate()
                .header("username", jwtUtils.extractUserName(token))
                .build();
        }

        return chain.filter(exchange.mutate().request(request).build());
    }

    private boolean authMissing(ServerHttpRequest request) {
        return !request.getHeaders().containsKey("Authorization");
    }

    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }
}
