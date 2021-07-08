/**
 * 
 */
package com.ing.assignment.repo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author soubeher
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DEBIT_CARDS")
public class DebitCardsEntity {

	@Id
	private int sequenceNumber;
	private String account;
	private int cardNumber;
	private int id;
	private String status;
	private long atmLimit;
	private String atmPeriodUnit;
	private long posLimit;
	private String posPeriodUnit;
	private boolean contactless;
	private String cardHolderId;

}
