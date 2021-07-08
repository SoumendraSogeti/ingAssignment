package com.ing.assignment.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER_AGREEMENT")
public class UserAgreementEntity {
    @Id
    private int id;
    private int userId;
    private String agreementType;
    private long agreementAccount;
}
