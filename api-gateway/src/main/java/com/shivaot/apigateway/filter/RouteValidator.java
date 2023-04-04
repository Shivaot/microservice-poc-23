package com.shivaot.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/**
 * Shiva Created on 04/04/23
 */
@Component
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of("/auth/register","/auth/token","/eureka");

    public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));

}
