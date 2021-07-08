package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardNumberTest {
    @Test
    public void debitCardNumberTest(){
        DebitCardNumber debitCardNumber = new DebitCardNumber("1111");
        assertThat(debitCardNumber.debitCardNumber).isEqualTo("1111");
        assertThat(debitCardNumber.asInt()).isEqualTo(1111);
    }
}
