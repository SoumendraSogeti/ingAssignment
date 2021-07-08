package com.ing.assignment.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AtmLimit {
    long limit;
    String periodUnit;
}
