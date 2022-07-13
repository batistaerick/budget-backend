package com.erick.finance.controllers;

import com.erick.finance.dtos.FinanceDTO;
import com.erick.finance.services.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/finances")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService service;

    @GetMapping("/")
    public ResponseEntity<List<FinanceDTO>> getMonthlyAmount(@RequestParam String userID,
                                                             @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                             @RequestParam LocalDate end) {
        return ResponseEntity.ok(service.getMonthlyAmount(userID, end));
    }

}