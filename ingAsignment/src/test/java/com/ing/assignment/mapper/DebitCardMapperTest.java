package com.ing.assignment.mapper;

import com.ing.assignment.domain.AtmLimit;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.domain.PosLimit;
import com.ing.assignment.dto.DebitCardDTO;
import com.ing.assignment.repo.DebitCardsEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardMapperTest {
    @Test
    public void toDebitCardDomainTest(){
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
        DebitCard debitCard = DebitCardMapper.toDebitCardDomain(debitCardsEntity);
        assertThat(debitCardsEntity.getCardNumber()).isEqualTo(debitCard.getCardNumber());
        assertThat(debitCardsEntity.getAtmLimit()).isEqualTo(debitCard.getAtmLimit().getLimit());
        assertThat(debitCardsEntity.getCardHolderId()).isEqualTo(debitCard.getCardHolder());
        assertThat(debitCardsEntity.getSequenceNumber()).isEqualTo(debitCard.getSequenceNumber());
        assertThat(debitCardsEntity.getId()).isEqualTo(debitCard.getId());
        assertThat(debitCardsEntity.getPosLimit()).isEqualTo(debitCard.getPosLimit().getLimit());
        assertThat(debitCardsEntity.getStatus()).isEqualTo(debitCard.getStatus());

    }
    @Test
    public void toDebitCardDTOTest(){
        DebitCard debitCard =DebitCard.builder()
                .cardHolder("User1")
                .cardNumber(1111)
                .id(1)
                .status("ACTIVE")
                .sequenceNumber(1)
                .atmLimit(AtmLimit.builder().limit(100).periodUnit("PER_WEEK").build())
                .posLimit(PosLimit.builder().limit(200).periodUnit("PER_MONTH").build())
                .contactless(true).build();
        DebitCardDTO debitCardDTO = DebitCardMapper.toDebitCardDTO(debitCard);
        assertThat(debitCardDTO.getCardNumber()).isEqualTo(debitCard.getCardNumber());
        assertThat(debitCardDTO.getCardHolder()).isEqualTo(debitCard.getCardHolder());
        assertThat(debitCardDTO.getId()).isEqualTo(debitCard.getId());
        assertThat(debitCardDTO.getStatus()).isEqualTo(debitCard.getStatus());
        assertThat(debitCardDTO.getSequenceNumber()).isEqualTo(debitCard.getSequenceNumber());
        assertThat(debitCardDTO.getAtmLimit().getLimit()).isEqualTo(debitCard.getAtmLimit().getLimit());
        assertThat(debitCardDTO.getAtmLimit().getPeriodUnit()).isEqualTo(debitCard.getAtmLimit().getPeriodUnit());
        assertThat(debitCardDTO.getPosLimit().getLimit()).isEqualTo(debitCard.getPosLimit().getLimit());
        assertThat(debitCardDTO.getPosLimit().getPeriodUnit()).isEqualTo(debitCard.getPosLimit().getPeriodUnit());
        assertThat(debitCardDTO.isContactless()).isEqualTo(debitCard.isContactless());


    }


}
