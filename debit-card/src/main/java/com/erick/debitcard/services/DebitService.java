package com.erick.debitcard.services;

import com.erick.debitcard.clients.UserClient;
import com.erick.debitcard.converters.DebitConverter;
import com.erick.debitcard.dtos.DebitDTO;
import com.erick.debitcard.entities.Debit;
import com.erick.debitcard.repositories.DebitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebitService {

    private final DebitRepository repository;
    private final DebitConverter converter;
    private final UserClient userClient;

    public Debit save(DebitDTO dto) {
        userClient.decreaseAmount(dto.getValue(), dto.getUserId());
        return repository.save(converter.dtoToEntity(dto));
    }

    public List<Debit> findAll() {
        return repository.findAll();
    }

    public List<Debit> findByUserIdAndDateTimeBetween(String userId, LocalDate start, LocalDate end) {
        return repository.findByUserIdAndDateTimeBetween(userId, start, end);
    }

}