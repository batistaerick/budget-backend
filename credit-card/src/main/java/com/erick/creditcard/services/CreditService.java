package com.erick.creditcard.services;

import com.erick.creditcard.converters.CreditConverter;
import com.erick.creditcard.dtos.CreditDTO;
import com.erick.creditcard.dtos.UserDTO;
import com.erick.creditcard.entities.Credit;
import com.erick.creditcard.repositories.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
            dto.setDateTime(dto.getDateTime().plusMonths(1));
            repository.save(converter.dtoToEntity(dto));
        }
    }

    public List<Credit> findAll() {
        return repository.findAll();
    }

    public List<Credit> findByUserID(String userID) {
        return repository.findByUserId(userID);
    }

    public List<Credit> findByUserIdAndDateTimeBetween(String userId, LocalDate start, LocalDate end) {
        return repository.findByUserIdAndDateTimeBetween(userId, start, end);
    }

    private List<Credit> getCreditsOfOneYear(String userId) {
        LocalDate now = LocalDate.now();
        LocalDate start = LocalDate.of(now.getYear(), now.getMonth(), LocalDate.MAX.getDayOfMonth() - 1);
        LocalDate end = LocalDate.of(now.plusYears(1).getYear(), now.plusMonths(1).getMonth(),
                LocalDate.MIN.getDayOfMonth());
        return repository.findByUserIdAndDateTimeBetween(userId, start, end);
    }

    public List<Double> getExpensesOfOneYear(String userId) {
        List<Double> monthlyExpenses = new ArrayList<>();
        List<Credit> credits = this.getCreditsOfOneYear(userId);
        for (int i = 1; i <= 12; i++) {
            int counter = i;
            monthlyExpenses.add(credits.stream()
                    .filter(credit -> credit.getDateTime().getMonth() == LocalDate.now().plusMonths(counter).getMonth())
                    .mapToDouble(Credit::getValue).sum());
        }
        return monthlyExpenses;
    }

}