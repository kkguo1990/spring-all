package com.kk.eruka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ErukaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErukaClientApplication.class, args);
    }

}
