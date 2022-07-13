package com.erick.finance.services;

import com.erick.finance.clients.CreditClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditClient creditClient;

    public List<Double> getExpenses(String userID, LocalDate start, LocalDate end) {
        return creditClient.getExpenses(userID, start, end);
    }

}