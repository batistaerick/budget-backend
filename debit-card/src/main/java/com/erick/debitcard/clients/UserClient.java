package com.erick.debitcard.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user", url = "localhost:8080", path = "/users")
public interface UserClient {

    @PutMapping("/decrease-amount")
    void decreaseAmount(@RequestParam Double value, @RequestParam String userId);

}