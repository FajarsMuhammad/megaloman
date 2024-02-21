package com.kinumz.gateway.config;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RouteValidator {

    public static final List<String> openEndpoints = List.of(
        "/api/v1/auth/signup",
        "/api/v1/auth/signin",
        "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
        request -> openEndpoints.stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
