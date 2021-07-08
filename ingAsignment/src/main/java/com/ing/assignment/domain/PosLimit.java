package com.ing.assignment.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PosLimit {
    long limit;
    String periodUnit;
}
