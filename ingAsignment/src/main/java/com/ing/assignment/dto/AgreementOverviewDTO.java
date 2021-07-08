package com.ing.assignment.dto;

import com.ing.assignment.domain.Agreements;
import com.ing.assignment.domain.DebitCard;
import com.ing.assignment.domain.DebitCards;
import lombok.Builder;
import lombok.Value;

import java.util.List;
@Value
@Builder
public class AgreementOverviewDTO {

    String user;
    List<Agreements> agreements;
    List<String> accountNumbers;
    List<DebitCards> debitCards;
    List<DebitCard> debitCard;

}
