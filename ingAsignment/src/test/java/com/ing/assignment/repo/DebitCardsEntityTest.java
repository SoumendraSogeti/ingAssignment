package com.ing.assignment.repo;

import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.mapper.DebitCardMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardsEntityTest {
    @Test
    public void debitCardsEntityTest(){
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

        assertThat(debitCardsEntity.getCardNumber()).isEqualTo(1111);
        assertThat(debitCardsEntity.getAtmLimit()).isEqualTo(3000);
        assertThat(debitCardsEntity.getAtmPeriodUnit()).isEqualTo("PER_WEEK");
        assertThat(debitCardsEntity.getCardHolderId()).isEqualTo("User1");
        assertThat(debitCardsEntity.getSequenceNumber()).isEqualTo(1);
        assertThat(debitCardsEntity.getId()).isEqualTo(1111);
        assertThat(debitCardsEntity.getPosLimit()).isEqualTo(50);
        assertThat(debitCardsEntity.getPosPeriodUnit()).isEqualTo("PER_MONTH");
        assertThat(debitCardsEntity.getStatus()).isEqualTo("ACTIVE");
        assertThat(debitCardsEntity.getAccount()).isEqualTo("IBAN1234567890");
        assertThat(debitCardsEntity.isContactless()).isEqualTo(true);
    }
}
