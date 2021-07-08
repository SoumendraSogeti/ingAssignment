package com.ing.assignment.domain;

import lombok.Value;

import java.util.List;

@Value
public class User {
    Integer userId;
    List<Agreements> agreements;
}
