package com.erick.debitcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DebitCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DebitCardApplication.class, args);
    }
}