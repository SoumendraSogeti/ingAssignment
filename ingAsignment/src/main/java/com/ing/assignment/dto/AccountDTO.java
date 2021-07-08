package com.ing.assignment.dto;

import com.ing.assignment.domain.DebitCards;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class AccountDTO {
    String account;
    long balance;
    LocalDate created;
    String user;
    List<DebitCards> debitCards;


}
