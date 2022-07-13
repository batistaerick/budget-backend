package com.erick.creditcard.repositories;

import com.erick.creditcard.entities.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CreditRepository extends MongoRepository<Credit, String> {

    List<Credit> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate end);

    List<Credit> findByUserId(String userID);

}