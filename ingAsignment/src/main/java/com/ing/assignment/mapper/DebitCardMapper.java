package com.ing.assignment.mapper;

import com.ing.assignment.domain.AtmLimit;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.domain.DebitCards;
import com.ing.assignment.domain.PosLimit;
import com.ing.assignment.dto.DebitCardDTO;
import com.ing.assignment.repo.DebitCardsEntity;

import java.util.List;
import java.util.stream.Collectors;

public class DebitCardMapper {

    public static List<com.ing.assignment.domain.DebitCards> toDebitCardList(List<DebitCardsEntity> debitCardEntities) {

        return debitCardEntities.stream().map(DebitCardsEntity::getCardNumber).
                map(tempCardNumber -> {
                    DebitCards debitCard = new DebitCards(tempCardNumber);
                    return debitCard;
                }).collect(Collectors.toList());
    }

    public static DebitCard toDebitCardDomain(DebitCardsEntity debitCard) {
        return DebitCard.builder().id(debitCard.getId())
                .status(debitCard.getStatus())
                .cardNumber(debitCard.getCardNumber())
                .sequenceNumber(debitCard.getSequenceNumber())
                .cardHolder(debitCard.getCardHolderId())
                .atmLimit(AtmLimit.builder().limit(debitCard.getAtmLimit()).periodUnit(debitCard.getAtmPeriodUnit()).build())
                .posLimit(PosLimit.builder().limit(debitCard.getPosLimit()).periodUnit(debitCard.getPosPeriodUnit()).build())
                .contactless(debitCard.isContactless()).build();
    }

    public static DebitCardDTO toDebitCardDTO(DebitCard debitCard) {
        return DebitCardDTO.builder().id(debitCard.getId())
                .status(debitCard.getStatus())
                .cardNumber(debitCard.getCardNumber())
                .sequenceNumber(debitCard.getSequenceNumber())
                .cardHolder(debitCard.getCardHolder())
                .atmLimit(debitCard.getAtmLimit())
                .posLimit(debitCard.getPosLimit())
                .contactless(debitCard.isContactless()).build();
    }
}
