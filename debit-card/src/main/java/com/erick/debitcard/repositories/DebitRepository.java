package com.erick.debitcard.repositories;

import com.erick.debitcard.entities.Debit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface DebitRepository extends MongoRepository<Debit, String> {

    List<Debit> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate end);

}