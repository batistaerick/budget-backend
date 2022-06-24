package com.erick.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(CreditCardApplication.class, args);
    }
}