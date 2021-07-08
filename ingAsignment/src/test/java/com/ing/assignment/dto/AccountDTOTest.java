package com.ing.assignment.dto;

import com.ing.assignment.domain.DebitCards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDTOTest {
    @Test
    public void accountDTOTest(){
        List<DebitCards> debitCardList = new ArrayList<>();
        debitCardList.add(new DebitCards(111));
        AccountDTO accountDTO = AccountDTO.builder().account("IBAN1234567890")
                .balance(100)
                .user("User1")
                .debitCards(debitCardList).build();


        assertThat("IBAN1234567890").isEqualTo(accountDTO.getAccount());
        assertThat(100).isEqualTo(accountDTO.getBalance());
        assertThat("User1").isEqualTo(accountDTO.getUser());
        assertThat(111).isEqualTo(accountDTO.getDebitCards().get(0).getCardId());

    }
}
