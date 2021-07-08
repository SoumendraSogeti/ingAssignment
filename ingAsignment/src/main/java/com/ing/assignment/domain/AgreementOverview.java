package com.ing.assignment.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class AgreementOverview {
    String user;
    List<Agreements> agreements;
    List<String> accountNumbers;
    List<DebitCards> debitCards;
    List<DebitCard> debitCard;
}
