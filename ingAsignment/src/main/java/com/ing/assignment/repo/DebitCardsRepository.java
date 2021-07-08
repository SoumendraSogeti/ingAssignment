package com.ing.assignment.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DebitCardsRepository extends CrudRepository<DebitCardsEntity,Integer> {
    @Query("SELECT d FROM DebitCardsEntity d WHERE d.status !='BLOCKED' and d.cardNumber = :cardNumber")
    DebitCardsEntity findDebitCardByCardNumber(int cardNumber);
}
