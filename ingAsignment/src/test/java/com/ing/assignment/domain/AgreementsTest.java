package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgreementsTest {
    @Test
    public void  agreementsTest(){

        Agreements agreements = Agreements.builder().account(111).type("IBAN").build();
        assertThat(agreements.getType()).isEqualTo("IBAN");
        assertThat(agreements.getAccount()).isEqualTo(111);
    }
}
