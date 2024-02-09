package com.kinumz.gateway.config;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class RouteValidator {

    public static final List<String> openEndpoints = List.of(
        "auth/register"
    );

    public Predicate<ServerHttpRequest> isSecured =
        request -> openEndpoints.stream()
            .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
