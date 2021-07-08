package com.ing.assignment.mapper;

import com.ing.assignment.domain.AgreementOverview;
import com.ing.assignment.dto.AgreementOverviewDTO;

public class AgreementOverviewMapper {

    public static AgreementOverviewDTO toAgreementOverviewDTO(AgreementOverview agreementOverview) {
        return AgreementOverviewDTO.builder().user(agreementOverview.getUser())
                .agreements(agreementOverview.getAgreements())
                .accountNumbers(agreementOverview.getAccountNumbers())
                .debitCards(agreementOverview.getDebitCards())
                .debitCard(agreementOverview.getDebitCard()).build();
    }
}
