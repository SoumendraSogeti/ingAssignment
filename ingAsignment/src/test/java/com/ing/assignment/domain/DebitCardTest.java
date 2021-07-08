package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardTest {
    @Test
    public void debitCardTest(){
        DebitCard debitCard =DebitCard.builder()
                .cardHolder("User1")
                .cardNumber(1111)
                .id(1)
                .status("ACTIVE")
                .sequenceNumber(1)
                .atmLimit(AtmLimit.builder().limit(100).periodUnit("PER_WEEK").build())
                .posLimit(PosLimit.builder().limit(200).periodUnit("PER_MONTH").build())
                .contactless(true).build();
        assertThat(1111).isEqualTo(debitCard.getCardNumber());
        assertThat(1).isEqualTo(debitCard.getId());
        assertThat("User1").isEqualTo(debitCard.getCardHolder());
        assertThat("ACTIVE").isEqualTo(debitCard.getStatus());
        assertThat(1).isEqualTo(debitCard.getSequenceNumber());
        assertThat(100).isEqualTo(debitCard.getAtmLimit().getLimit());
        assertThat("PER_WEEK").isEqualTo(debitCard.getAtmLimit().getPeriodUnit());
        assertThat(200).isEqualTo(debitCard.getPosLimit().getLimit());
        assertThat("PER_MONTH").isEqualTo(debitCard.getPosLimit().getPeriodUnit());
        assertThat(true).isEqualTo(debitCard.isContactless());

    }

}
