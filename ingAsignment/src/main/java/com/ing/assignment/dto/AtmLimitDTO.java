package com.ing.assignment.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AtmLimitDTO {
    long limit;
    String periodUnit;
}
