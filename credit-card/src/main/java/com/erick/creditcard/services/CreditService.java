package com.erick.creditcard.services;

import com.erick.creditcard.converters.CreditConverter;
import com.erick.creditcard.dtos.CreditDTO;
import com.erick.creditcard.dtos.UserDTO;
import com.erick.creditcard.entities.Credit;
import com.erick.creditcard.repositories.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository repository;
    private final CreditConverter converter;
    private final UserService userService;

    public void save(CreditDTO dto) {
        userService.findById(dto.getUserId());
        dto.setValue(dto.getValue() / dto.getInstallment());
        for (int i = 0; i < dto.getInstallment(); i++) {
            dto.setDate(dto.getDate().plusMonths(1));
            repository.save(converter.dtoToEntity(dto));
        }
    }

    public List<Credit> findAll() {
        return repository.findAll();
    }

    public List<Credit> findByUserID(String userID) {
        return repository.findByUserId(userID);
    }

    public List<Credit> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate end) {
        return repository.findByUserIdAndDateBetween(userId, start.minusDays(1), end.plusDays(1));
    }

    public List<Double> getExpenses(String userId, LocalDate start, LocalDate end) {
        List<Credit> credits = findByUserIdAndDateBetween(userId, start, end);
        List<Double> monthlyExpenses = new ArrayList<>();
        int months = Period.between(start, end).getMonths();
        for (int i = 1; i <= months; i++) {
            int counter = i;
            monthlyExpenses.add(credits.stream()
                    .filter(credit -> credit.getDate().getMonth() == LocalDate.now().plusMonths(counter).getMonth())
                    .mapToDouble(Credit::getValue).sum());
        }
        return monthlyExpenses;
    }

}