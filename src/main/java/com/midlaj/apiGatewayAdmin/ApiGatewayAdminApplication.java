package com.midlaj.apiGatewayAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

public class ApiGatewayAdminApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayAdminApplication.class, args);
    }

}
