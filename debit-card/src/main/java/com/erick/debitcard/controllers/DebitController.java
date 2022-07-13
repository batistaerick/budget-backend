package com.erick.debitcard.controllers;

import com.erick.debitcard.dtos.DebitDTO;
import com.erick.debitcard.entities.Debit;
import com.erick.debitcard.services.DebitService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/debits")
@RequiredArgsConstructor
public class DebitController {

    private final DebitService service;

    @PostMapping
    public ResponseEntity<Debit> save(@RequestBody DebitDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<Debit>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find-between")
    public ResponseEntity<List<Debit>> findByUserIdAndDateTimeBetween(@RequestParam String userId,
                                                                      @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                                      @RequestParam LocalDate start,
                                                                      @DateTimeFormat(pattern = "dd/MM/yyyy")
                                                                      @RequestParam LocalDate end) {
        return ResponseEntity.ok(service.findByUserIdAndDateBetween(userId, start, end));
    }

}