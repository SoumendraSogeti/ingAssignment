package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
    @Test
    public void testAccount(){

        List<DebitCards> debitCardList = new ArrayList<>();
        debitCardList.add(new DebitCards(111));
        Account account = Account.builder().account("IBAN1234567890")
                .user("User1")
                .balance(100)
                .debitCards(debitCardList).build();

        assertThat(account.getAccount()).isEqualTo("IBAN1234567890");
        assertThat(account.getUser()).isEqualTo("User1");
        assertThat(account.getBalance()).isEqualTo(100);
        assertThat(account.getDebitCards().get(0).getCardId()).isEqualTo(debitCardList.get(0).getCardId());

    }
}
