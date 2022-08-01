package com.erick.finance.clients;

import com.erick.finance.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", path = "/users")
public interface UserClient {

    @GetMapping("/{id}")
    UserDTO findById(@PathVariable String id);

}