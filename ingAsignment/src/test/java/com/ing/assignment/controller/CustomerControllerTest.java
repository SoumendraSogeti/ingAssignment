package com.ing.assignment.controller;

import com.ing.assignment.domain.AgreementOverview;
import com.ing.assignment.domain.Agreements;
import com.ing.assignment.domain.UserAgreementNumber;
import com.ing.assignment.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import junitparams.JUnitParamsRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(JUnitParamsRunner.class)


public class CustomerControllerTest {



    @Mock
    private CustomerService customerService;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testGetAgreement() {
        UserAgreementNumber userAgreementNumber = new UserAgreementNumber("111");
        Agreements agreement = Agreements.builder().account(12345).type("IBAN").build();

        List<Agreements> agreementsList = new ArrayList<>();
        agreementsList.add(agreement);

        when(customerService.fetchUserAgreement(eq(userAgreementNumber.asInt()))).thenReturn(agreementsList);
        final ResponseEntity responseEntity = customerController.getAgreement("111");
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(200);
        verify(customerService, times(1)).fetchUserAgreement(userAgreementNumber.asInt());
    }



}
