package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAgreementNumberTest {
    @Test
    public void userAgreementNumberTest(){
        UserAgreementNumber userAgreementNumber = new UserAgreementNumber("1111");
        assertThat(userAgreementNumber.userAgreementNumber).isEqualTo("1111");
        assertThat(userAgreementNumber.asInt()).isEqualTo(1111);
    }
}
