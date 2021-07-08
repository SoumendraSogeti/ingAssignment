package com.ing.assignment.dto;

import com.ing.assignment.domain.*;
import com.ing.assignment.mapper.AgreementOverviewMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementOverviewDTOTest {
    @Test
    public void agreementOverviewDTOTest(){
        List<Agreements> agreements = new ArrayList<>();
        Agreements agreement =Agreements.builder().account(1234567890).type("IBAN").build();
        agreements.add(agreement);

        List<DebitCards> debitCards = new ArrayList<>();
        debitCards.add(new DebitCards(111));

        DebitCard debitCard =DebitCard.builder()
                .cardHolder("User1")
                .cardNumber(1111)
                .id(1)
                .status("ACTIVE")
                .sequenceNumber(1)
                .atmLimit(AtmLimit.builder().limit(100).periodUnit("PER_WEEK").build())
                .posLimit(PosLimit.builder().limit(200).periodUnit("PER_MONTH").build())
                .contactless(true).build();
        List<DebitCard> debitCardList = new ArrayList<>();
        debitCardList.add(debitCard);

        List<String> accounts = new ArrayList<>();
        accounts.add("IBAN1234567890");

        AgreementOverviewDTO agreementOverviewDTO = AgreementOverviewDTO.builder().
                user("User1")
                .agreements(agreements)
                .debitCards(debitCards)
                .debitCard(debitCardList).accountNumbers(accounts).build();


        assertThat(agreementOverviewDTO.getUser()).isEqualTo("User1");
        assertThat(agreementOverviewDTO.getAgreements().get(0).getAccount()).isEqualTo(1234567890);
        assertThat(agreementOverviewDTO.getAgreements().get(0).getType()).isEqualTo("IBAN");
        assertThat(agreementOverviewDTO.getAccountNumbers().get(0)).isEqualTo("IBAN1234567890");
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getCardNumber()).isEqualTo(1111);
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getId()).isEqualTo(1);
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getCardHolder()).isEqualTo("User1");
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getStatus()).isEqualTo("ACTIVE");
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getSequenceNumber()).isEqualTo(1);
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getAtmLimit().getLimit()).isEqualTo(100);
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getAtmLimit().getPeriodUnit()).isEqualTo("PER_WEEK");
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getPosLimit().getLimit()).isEqualTo(200);
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getPosLimit().getPeriodUnit()).isEqualTo("PER_MONTH");
        assertThat(agreementOverviewDTO.getDebitCard().get(0).isContactless()).isEqualTo(true);
        assertThat(agreementOverviewDTO.getDebitCards().get(0).getCardId()).isEqualTo(111);
    }
}
