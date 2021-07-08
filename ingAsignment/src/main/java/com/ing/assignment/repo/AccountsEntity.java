/**
 * 
 */
package com.ing.assignment.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * @author soubeher
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ACCOUNTS")
public class AccountsEntity {
	@Id
	private String account;
	private long balance;
	private LocalDate created;
	private int userId;
	@OneToMany(mappedBy = "account")
	private List<DebitCardsEntity> debitCardEntities;
}
