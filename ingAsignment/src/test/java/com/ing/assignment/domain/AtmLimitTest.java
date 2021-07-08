package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtmLimitTest {
    @Test
    public void atmLimitTest(){
        AtmLimit atmLimit = AtmLimit.builder().limit(100).periodUnit("PER_MONTH").build();
        assertThat(atmLimit.getLimit()).isEqualTo(100);
        assertThat(atmLimit.getPeriodUnit()).isEqualTo("PER_MONTH");
    }
}
