package com.nttdata.bootcamp.msgateway.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayBeans {

  @Bean
  public RouteLocator routeLocator(RouteLocatorBuilder builder){
    return builder
      .routes()
      .route(route -> route
        .path("/api/customers/personal/**")
        .uri("lb://ms-customers")
        )
      .route(route -> route
        .path("/api/customers/business/**")
        .uri("lb://ms-customers")
        )
        .route(route -> route
        .path("/api/products/banks-accounts/**")
        .uri("lb://ms-products")
        )
        .route(route -> route
        .path("/api/personal-product/**")
        .uri("lb://ms-personal-product")
        )
        .route(route -> route
        .path("/api/business-product/**")
        .uri("lb://ms-personal-product")
        )
        .route(route -> route
        .path("/api/transactions/**")
        .uri("lb://ms-transactions")
        )
      .build();
  }
}
