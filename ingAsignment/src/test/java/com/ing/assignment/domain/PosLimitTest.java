package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PosLimitTest {

    @Test
    public void posLimitTest(){
        PosLimit posLimit = PosLimit.builder().limit(100).periodUnit("PER_MONTH").build();
        assertThat(posLimit.getLimit()).isEqualTo(100);
        assertThat(posLimit.getPeriodUnit()).isEqualTo("PER_MONTH");
    }
}
