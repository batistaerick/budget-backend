package com.erick.finance.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "credit", url = "localhost:8081", path = "/credits")
public interface CreditClient {

    @GetMapping("/expenses-of-one-year/{userID}")
    List<Double> getTotalExpenses(@PathVariable String userID);

}