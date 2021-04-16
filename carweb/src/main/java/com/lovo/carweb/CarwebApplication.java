package com.lovo.carweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.lovo.api.service")
public class CarwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarwebApplication.class, args);
    }

}
