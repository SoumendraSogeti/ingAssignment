package com.ing.assignment.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

@Value
@Builder
public class Account {
    String account;
    long balance;
    LocalDate created;
    String user;
    List<DebitCards> debitCards;
}
