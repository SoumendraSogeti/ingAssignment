package com.ing.assignment.mapper;

import com.ing.assignment.domain.*;
import com.ing.assignment.dto.AgreementOverviewDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementOverViewMapperTest {
    @Test
    public void toAgreementOverviewDTOTest(){
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

        AgreementOverviewDTO agreementOverviewDTO = AgreementOverviewMapper.toAgreementOverviewDTO(agreementOverview);
        assertThat(agreementOverviewDTO.getUser()).isEqualTo(agreementOverview.getUser());
        assertThat(agreementOverviewDTO.getAgreements().get(0).getAccount()).isEqualTo(agreementOverview.getAgreements().get(0).getAccount());
        assertThat(agreementOverviewDTO.getAgreements().get(0).getType()).isEqualTo(agreementOverview.getAgreements().get(0).getType());
        assertThat(agreementOverviewDTO.getAccountNumbers().get(0)).isEqualTo(agreementOverview.getAccountNumbers().get(0));
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getCardNumber()).isEqualTo(agreementOverview.getDebitCard().get(0).getCardNumber());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getId()).isEqualTo(agreementOverview.getDebitCard().get(0).getId());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getCardHolder()).isEqualTo(agreementOverview.getDebitCard().get(0).getCardHolder());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getStatus()).isEqualTo(agreementOverview.getDebitCard().get(0).getStatus());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getSequenceNumber()).isEqualTo(agreementOverview.getDebitCard().get(0).getSequenceNumber());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getAtmLimit().getLimit()).isEqualTo(agreementOverview.getDebitCard().get(0).getAtmLimit().getLimit());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getAtmLimit().getPeriodUnit()).isEqualTo(agreementOverview.getDebitCard().get(0).getAtmLimit().getPeriodUnit());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getPosLimit().getLimit()).isEqualTo(agreementOverview.getDebitCard().get(0).getPosLimit().getLimit());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).getPosLimit().getPeriodUnit()).isEqualTo(agreementOverview.getDebitCard().get(0).getPosLimit().getPeriodUnit());
        assertThat(agreementOverviewDTO.getDebitCard().get(0).isContactless()).isEqualTo(agreementOverview.getDebitCard().get(0).isContactless());
        assertThat(agreementOverviewDTO.getDebitCards().get(0).getCardId()).isEqualTo(agreementOverview.getDebitCards().get(0).getCardId());

    }
}
