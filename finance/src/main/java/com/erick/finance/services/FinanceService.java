package com.erick.finance.services;

import com.erick.finance.dtos.FinanceDTO;
import com.erick.finance.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private final CreditService creditService;
    private final UserService userService;

    public List<FinanceDTO> monthlyAmountOfOneYear(String userID) {
        List<Double> creditExpenses = creditService.getTotalExpenses(userID);
        UserDTO userDTO = userService.findById(userID);
        Double totalExpenses = userDTO.getExpenses().stream().mapToDouble(value -> value).sum();

        return creditExpenses.stream().map(credit -> {
            FinanceDTO financeDTO = new FinanceDTO();
            financeDTO.setTotalExpenses(totalExpenses);
            financeDTO.setTotalCredit(credit);
            financeDTO.setRemainingAmount(userDTO.getAmount() + userDTO.getSalary() + userDTO.getExtra()
                    - credit - financeDTO.getTotalExpenses());
            userDTO.setAmount(financeDTO.getRemainingAmount());
            return financeDTO;
        }).toList();
    }

}