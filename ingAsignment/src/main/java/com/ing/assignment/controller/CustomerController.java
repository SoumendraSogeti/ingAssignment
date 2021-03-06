package com.ing.assignment.controller;

import com.ing.assignment.domain.*;
import com.ing.assignment.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.ing.assignment.mapper.AccountMapper.toAccountDTO;
import static com.ing.assignment.mapper.AgreementMapper.toAgreementDTO;
import static com.ing.assignment.mapper.AgreementOverviewMapper.toAgreementOverviewDTO;
import static com.ing.assignment.mapper.DebitCardMapper.toDebitCardDTO;


@RestController
@Component
@AllArgsConstructor
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);


    private final CustomerService customerService;


    /**
     * This method is to Aggregated product details of an user
     *
     * @param user
     * @return Products in JSON format
     */
    @RequestMapping(value = "/agreement-overview/{user}", produces = {"application/json"}, method = {RequestMethod.GET})
    public ResponseEntity agreementOverView(@PathVariable("user") String user) {
        try {
            UserAgreementNumber userAgreementNumber = new UserAgreementNumber(user);
            AgreementOverview agreementOverview = customerService.fetchAgreementOverview(userAgreementNumber.asInt());
            return ResponseEntity.ok(toAgreementOverviewDTO(agreementOverview));
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "agreementOverView not found", exception);
        }


    }


    /**
     * Fetch the Agreements based an user
     *
     * @param user
     * @return Agreements in JSON format
     */
    @RequestMapping(value = "/agreements/{user}", produces = {"application/json"}, method = {RequestMethod.GET})
    public ResponseEntity getAgreement(@PathVariable("user") String user) {
        try {
            UserAgreementNumber userAgreementNumber = new UserAgreementNumber(user);
            List<Agreements> agreements = customerService.fetchUserAgreement(userAgreementNumber.asInt());

            return ResponseEntity.ok(toAgreementDTO(agreements));
        } catch (Exception exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Agreements not found", exception);
        }

    }

    /**
     * Fetch the accounts details based on account id
     *
     * @param accountId
     * @return Accounts in JSON format
     */
    @RequestMapping(value = "/account/{accountId}", produces = {"application/json"}, method = {RequestMethod.GET})
    public ResponseEntity getAccounts(@PathVariable("accountId") String accountId) {
        try {
            AccountNumber accountNumber = new AccountNumber(accountId);
            Account accounts = customerService.fetchAccounts(accountNumber.asString());
            return ResponseEntity.ok(toAccountDTO(accounts));
        } catch (Exception exception) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Account not found", exception);

        }

    }

    /**
     * Fetch DebitCard details based on cardId
     *
     * @param cardId
     * @return DebitCards in JSON format
     */

    @RequestMapping(value = "/debit-cards/{cardId}", produces = {"application/json"}, method = {RequestMethod.GET})
    public ResponseEntity getDebitCards(@PathVariable("cardId") String cardId) {
        try {
            DebitCardNumber debitCardNumber = new DebitCardNumber(cardId);
            DebitCard debitCards = customerService.fetchDebitCards(debitCardNumber.asInt());

            return ResponseEntity.ok(toDebitCardDTO(debitCards));
        } catch (Exception exception) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Card not found", exception);

        }

    }
}
