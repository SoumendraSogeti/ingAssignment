package com.ing.assignment.domain;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.Objects.isNull;


public class AccountNumber {
    private static final Pattern validAccountNumber = Pattern.compile("[a-zA-Z0-9]{14}");
    String accountNumber;

    public AccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        validate();
    }

    private void validate() {
        if (isNull(accountNumber) || !validAccountNumber.matcher(accountNumber).matches()) {
            try {
                throw new ValidationException(format("Account number '%s' is not valid", this.accountNumber));
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
    }

    public String asString() {
        return accountNumber;
    }
}
