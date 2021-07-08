package com.ing.assignment.dto;

import com.ing.assignment.domain.Agreements;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementDTOTest {
    @Test
    public void agreementDTOTest(){
        Agreements agreements = Agreements.builder().account(111).type("IBAN").build();
        List<Agreements> agreementsList = new ArrayList<>();
        agreementsList.add(agreements);
        AgreementDTO agreementDTO = AgreementDTO.builder().agreements(agreementsList).build();
        assertThat(agreementDTO.getAgreements().get(0).getType()).isEqualTo("IBAN");
        assertThat(agreementDTO.getAgreements().get(0).getAccount()).isEqualTo(111);

    }
}
