package com.ing.assignment.domain;

import com.ing.assignment.repo.DebitCardsEntity;
import lombok.Builder;
import lombok.Value;

import java.util.function.Consumer;

@Value
@Builder
public class DebitCard implements Consumer<DebitCardsEntity> {
    long id;
    String status;
    long cardNumber;
    long sequenceNumber;
    String cardHolder;
    AtmLimit atmLimit;
    PosLimit posLimit;
    boolean contactless;

    /**
     * Performs this operation on the given argument.
     *
     * @param debitCardsEntity the input argument
     */
    @Override
    public void accept(DebitCardsEntity debitCardsEntity) {

    }
}
