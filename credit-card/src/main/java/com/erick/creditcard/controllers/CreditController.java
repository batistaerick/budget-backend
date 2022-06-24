package com.erick.creditcard.controllers;

import com.erick.creditcard.dtos.CreditDTO;
import com.erick.creditcard.entities.Credit;
import com.erick.creditcard.services.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService service;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CreditDTO dto) {
        service.save(dto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Credit>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{userID}")
    public ResponseEntity<List<Credit>> findByUserID(@PathVariable String userID) {
        return ResponseEntity.ok(service.findByUserID(userID));
    }

    @GetMapping("/find-between")
    public ResponseEntity<List<Credit>> findByUserIdAndDateTimeBetween(@RequestParam String userId,
                                                                       @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                                       @RequestParam LocalDate start,
                                                                       @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                                       @RequestParam LocalDate end) {
        return ResponseEntity.ok(service.findByUserIdAndDateTimeBetween(userId, start, end));
    }

    @GetMapping("/expenses-of-one-year/{userID}")
    public ResponseEntity<List<Double>> getTotalExpenses(@PathVariable String userID) {
        return ResponseEntity.ok(service.getExpensesOfOneYear(userID));
    }

}