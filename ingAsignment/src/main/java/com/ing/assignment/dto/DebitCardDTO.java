package com.ing.assignment.dto;

import com.ing.assignment.domain.AtmLimit;
import com.ing.assignment.domain.PosLimit;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class DebitCardDTO {
    long id;
    String status;
    long cardNumber;
    long sequenceNumber;
    String cardHolder;
    AtmLimit atmLimit;
    PosLimit posLimit;
    boolean contactless;

}
