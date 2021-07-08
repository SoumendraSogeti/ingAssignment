package com.ing.assignment.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardsTest {
    @Test
    public void debitCardsTest(){
        DebitCards debitCards = new DebitCards(1111);
        assertThat(debitCards.getCardId()).isEqualTo(1111);
    }
}
