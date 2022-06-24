package com.erick.finance.services;

import com.erick.finance.clients.CreditClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditClient creditClient;

    public List<Double> getTotalExpenses(@PathVariable String userID) {
        return creditClient.getTotalExpenses(userID);
    }

}