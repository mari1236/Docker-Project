package com.example.api_gateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "MariaIrfan")
						.addResponseHeader("Response", "Maria Here")
						.addRequestParameter("Param", "Maria Param"))
				.uri("http://httpbin.org:80")).build();
		
	}

}
