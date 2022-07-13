package com.erick.finance.services;

import com.erick.finance.dtos.FinanceDTO;
import com.erick.finance.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private final CreditService creditService;
    private final UserService userService;

    public List<FinanceDTO> getMonthlyAmount(String userID, LocalDate end) {
        LocalDate now = LocalDate.now();
        LocalDate start = LocalDate.of(now.getYear(), now.getMonth().plus(1), 1);

        List<Double> creditExpenses = creditService.getExpenses(userID, start, end);
        UserDTO userDTO = userService.findById(userID);
        Double totalExpenses = userDTO.getExpenses().stream().mapToDouble(Double::doubleValue).sum();

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