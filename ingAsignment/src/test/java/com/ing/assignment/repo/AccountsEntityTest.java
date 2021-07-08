package com.ing.assignment.repo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountsEntityTest {
    @Test
    public void accountEntityTest(){

        DebitCardsEntity debitCardsEntity = new DebitCardsEntity();
        debitCardsEntity.setCardNumber(1111);
        debitCardsEntity.setAtmLimit(3000);
        debitCardsEntity.setAtmPeriodUnit("PER_WEEK");
        debitCardsEntity.setContactless(true);
        debitCardsEntity.setId(1111);
        debitCardsEntity.setPosLimit(50);
        debitCardsEntity.setPosPeriodUnit("PER_MONTH");
        debitCardsEntity.setSequenceNumber(1);
        debitCardsEntity.setStatus("ACTIVE");
        debitCardsEntity.setAccount("IBAN1234567890");
        debitCardsEntity.setCardHolderId("User1");

        List<DebitCardsEntity> debitCardsEntityList = new ArrayList<>();
        debitCardsEntityList.add(debitCardsEntity);

        AccountsEntity accountsEntity = new AccountsEntity();
        accountsEntity.setAccount("IBAN1234567890");
        accountsEntity.setBalance(10);
        accountsEntity.setUserId(1);
        accountsEntity.setDebitCardEntities(debitCardsEntityList);

        assertThat(accountsEntity.getAccount()).isEqualTo("IBAN1234567890");
        assertThat(accountsEntity.getBalance()).isEqualTo(10);
        assertThat(accountsEntity.getUserId()).isEqualTo(1);
        assertThat(accountsEntity.getDebitCardEntities().get(0).getCardNumber()).isEqualTo(1111);
        assertThat(accountsEntity.getDebitCardEntities().get(0).getAccount()).isEqualTo("IBAN1234567890");
        assertThat(accountsEntity.getDebitCardEntities().get(0).getAtmLimit()).isEqualTo(3000);
        assertThat(accountsEntity.getDebitCardEntities().get(0).getAtmPeriodUnit()).isEqualTo("PER_WEEK");
        assertThat(accountsEntity.getDebitCardEntities().get(0).getPosLimit()).isEqualTo(50);
        assertThat(accountsEntity.getDebitCardEntities().get(0).getPosPeriodUnit()).isEqualTo("PER_MONTH");
        assertThat(accountsEntity.getDebitCardEntities().get(0).getSequenceNumber()).isEqualTo(1);
        assertThat(accountsEntity.getDebitCardEntities().get(0).getStatus()).isEqualTo("ACTIVE");
        assertThat(accountsEntity.getDebitCardEntities().get(0).getCardHolderId()).isEqualTo("User1");
        assertThat(accountsEntity.getDebitCardEntities().get(0).isContactless()).isEqualTo(true);
    }


}
