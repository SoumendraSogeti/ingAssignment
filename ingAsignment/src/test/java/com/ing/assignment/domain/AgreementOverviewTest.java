package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementOverviewTest {
    @Test
    public void agreementOverviewTest(){
        AgreementOverview agreementOverview = new AgreementOverview();
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

        agreementOverview.setUser("User1");
        agreementOverview.setAgreements(agreements);
        agreementOverview.setDebitCards(debitCards);
        agreementOverview.setDebitCard(debitCardList);
        agreementOverview.setAccountNumbers(accounts);

        assertThat("User1").isEqualTo(agreementOverview.getUser());
        assertThat(1234567890).isEqualTo(agreementOverview.getAgreements().get(0).getAccount());
        assertThat("IBAN").isEqualTo(agreementOverview.getAgreements().get(0).getType());
        assertThat("IBAN1234567890").isEqualTo(agreementOverview.getAccountNumbers().get(0));
        assertThat(1111).isEqualTo(agreementOverview.getDebitCard().get(0).getCardNumber());
        assertThat(1).isEqualTo(agreementOverview.getDebitCard().get(0).getId());
        assertThat("User1").isEqualTo(agreementOverview.getDebitCard().get(0).getCardHolder());
        assertThat("ACTIVE").isEqualTo(agreementOverview.getDebitCard().get(0).getStatus());
        assertThat(1).isEqualTo(agreementOverview.getDebitCard().get(0).getSequenceNumber());
        assertThat(100).isEqualTo(agreementOverview.getDebitCard().get(0).getAtmLimit().getLimit());
        assertThat("PER_WEEK").isEqualTo(agreementOverview.getDebitCard().get(0).getAtmLimit().getPeriodUnit());
        assertThat(200).isEqualTo(agreementOverview.getDebitCard().get(0).getPosLimit().getLimit());
        assertThat("PER_MONTH").isEqualTo(agreementOverview.getDebitCard().get(0).getPosLimit().getPeriodUnit());
        assertThat(true).isEqualTo(agreementOverview.getDebitCard().get(0).isContactless());
        assertThat(111).isEqualTo(agreementOverview.getDebitCards().get(0).getCardId());
    }
}
