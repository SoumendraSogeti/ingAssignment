package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AccountNumberTest {
    @Test
    public void accountNumberTest(){
        AccountNumber accountNumber = new AccountNumber("IBAN1234567890");
        assertThat(accountNumber.accountNumber).isEqualTo("IBAN1234567890");
        assertThat(accountNumber.asString()).isEqualTo("IBAN1234567890");
    }
}
