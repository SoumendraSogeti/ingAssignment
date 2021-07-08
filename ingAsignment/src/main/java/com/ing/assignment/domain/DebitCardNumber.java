package com.ing.assignment.domain;


import com.ing.assignment.controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public class DebitCardNumber {
    private static final Pattern validDebitCardNumber = Pattern.compile("\\d{4}");
    private static final Logger log = LoggerFactory.getLogger(DebitCardNumber.class);
    String debitCardNumber;

    public DebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
        validate();
    }

    private void validate() {
        if (isNull(debitCardNumber) || !validDebitCardNumber.matcher(debitCardNumber).matches()) {
            try {
                throw new ValidationException(format("Card number '%s' is not valid", this.debitCardNumber));
            } catch (ValidationException e) {
                log.error("Error while validation {}",e.getMessage());
            }
        }
    }

    public int asInt() {
        return Integer.parseInt(debitCardNumber);
    }
}
