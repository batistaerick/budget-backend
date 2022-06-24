package com.erick.creditcard.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "localhost:8080", path = "/users")
public interface UserClient {

    @GetMapping("/{id}")
    void findById(@PathVariable String id);

}