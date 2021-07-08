/**
 * 
 */
package com.ing.assignment.service;

import com.ing.assignment.domain.Account;
import com.ing.assignment.domain.AgreementOverview;
import com.ing.assignment.domain.Agreements;
import com.ing.assignment.domain.DebitCard;

import java.util.List;

/**
 * @author soubeher
 *
 */

public interface CustomerService {
	
	Account fetchAccounts(String accountId);
	DebitCard fetchDebitCards(int debitCardNumber);
	List <Agreements> fetchUserAgreement(int user);
	AgreementOverview fetchAgreementOverview(int user);

}
