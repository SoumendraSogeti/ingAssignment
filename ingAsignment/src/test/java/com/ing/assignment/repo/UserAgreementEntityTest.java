package com.ing.assignment.repo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserAgreementEntityTest {
    @Test
    public void userAgreementEntityTest(){
        UserAgreementEntity userAgreementEntity = new UserAgreementEntity();
        userAgreementEntity.setAgreementAccount(1234567890);
        userAgreementEntity.setUserId(1);
        userAgreementEntity.setAgreementType("IBAN");
        userAgreementEntity.setId(1);

        assertThat(userAgreementEntity.getAgreementAccount()).isEqualTo(1234567890);
        assertThat(userAgreementEntity.getUserId()).isEqualTo(1);
        assertThat(userAgreementEntity.getId()).isEqualTo(1);
        assertThat(userAgreementEntity.getAgreementType()).isEqualTo("IBAN");
    }
}
