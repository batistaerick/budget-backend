package com.erick.finance.controllers;

import com.erick.finance.dtos.FinanceDTO;
import com.erick.finance.services.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finances")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService service;

    @GetMapping("/{userID}")
    public ResponseEntity<List<FinanceDTO>> monthlyAmountOfOneYear(@PathVariable String userID) {
        return ResponseEntity.ok(service.monthlyAmountOfOneYear(userID));
    }

}