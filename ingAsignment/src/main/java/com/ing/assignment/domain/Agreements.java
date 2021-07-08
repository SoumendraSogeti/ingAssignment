package com.ing.assignment.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Agreements {
    String type;
    long account;
}
