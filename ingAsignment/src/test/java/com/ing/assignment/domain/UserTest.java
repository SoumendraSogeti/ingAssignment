package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    public void userTest() {

        List<Agreements> agreementsList = new ArrayList<>();
        Agreements agreements = Agreements.builder().account(111).type("IBAN").build();
        agreementsList.add(agreements);

        User user = new User(1, agreementsList);

        assertThat(user.getUserId()).isEqualTo(1);
        assertThat(user.getAgreements().get(0).getAccount()).isEqualTo(111);
        assertThat(user.getAgreements().get(0).getType()).isEqualTo("IBAN");


    }
}
