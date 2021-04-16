package com.lovo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //表明身份，是eureka的client端，启动后会自动注册进配置文件所写的地址的eureka中
@EnableDiscoveryClient  //服务发现
public class ManageserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageserviceApplication.class, args);
    }

}
