package com.lovo.mallweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("com.lovo.api.service")
public class MallwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallwebApplication.class, args);
    }

}
