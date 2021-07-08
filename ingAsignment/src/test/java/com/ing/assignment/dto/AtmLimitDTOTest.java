package com.ing.assignment.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AtmLimitDTOTest {
    @Test
    public void atmLimitDTOTest(){
        AtmLimitDTO  atmLimitDTO = AtmLimitDTO.builder().limit(100).periodUnit("Month").build();
        assertThat(atmLimitDTO.getLimit()).isEqualTo(100);
        assertThat(atmLimitDTO.getPeriodUnit()).isEqualTo("Month");
    }
}
