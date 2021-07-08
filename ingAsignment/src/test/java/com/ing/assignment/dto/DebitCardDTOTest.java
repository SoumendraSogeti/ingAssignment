package com.ing.assignment.dto;

import com.ing.assignment.domain.AtmLimit;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.domain.PosLimit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardDTOTest {
    @Test
    public void debitCardDTOTest(){
        DebitCardDTO debitCardDTO =DebitCardDTO.builder()
                .cardHolder("User1")
                .cardNumber(1111)
                .id(1)
                .status("ACTIVE")
                .sequenceNumber(1)
                .atmLimit(AtmLimit.builder().limit(100).periodUnit("PER_WEEK").build())
                .posLimit(PosLimit.builder().limit(200).periodUnit("PER_MONTH").build())
                .contactless(true).build();

        assertThat(1111).isEqualTo(debitCardDTO.getCardNumber());
        assertThat(1).isEqualTo(debitCardDTO.getId());
        assertThat("User1").isEqualTo(debitCardDTO.getCardHolder());
        assertThat("ACTIVE").isEqualTo(debitCardDTO.getStatus());
        assertThat(1).isEqualTo(debitCardDTO.getSequenceNumber());
        assertThat(100).isEqualTo(debitCardDTO.getAtmLimit().getLimit());
        assertThat("PER_WEEK").isEqualTo(debitCardDTO.getAtmLimit().getPeriodUnit());
        assertThat(200).isEqualTo(debitCardDTO.getPosLimit().getLimit());
        assertThat("PER_MONTH").isEqualTo(debitCardDTO.getPosLimit().getPeriodUnit());
        assertThat(true).isEqualTo(debitCardDTO.isContactless());


    }
}
