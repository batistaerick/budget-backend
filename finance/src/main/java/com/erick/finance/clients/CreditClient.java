package com.erick.finance.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "credit-card", path = "/credits")
public interface CreditClient {

    @GetMapping("/expenses")
    List<Double> getExpenses(@RequestParam String userID,
                             @DateTimeFormat(pattern = "dd/MM/yyyy")
                             @RequestParam LocalDate start,
                             @DateTimeFormat(pattern = "dd/MM/yyyy")
                             @RequestParam LocalDate end);

}