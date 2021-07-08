package com.ing.assignment.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.Objects.isNull;

public class UserAgreementNumber {
    private static final Pattern validDebitCardNumber=Pattern.compile("[+-]?[0-9]+");
    private static final Logger log = LoggerFactory.getLogger(DebitCardNumber.class);
    String userAgreementNumber;

    public UserAgreementNumber(String userAgreementNumber) {
        this.userAgreementNumber = userAgreementNumber;
        validate();
    }

    private void validate() {
        if (isNull(userAgreementNumber) || !validDebitCardNumber.matcher(userAgreementNumber).find()) {
            try {
                log.error("User is not valid {}",userAgreementNumber);
                throw new ValidationException(format("User '%s' is not valid", this.userAgreementNumber));
            } catch (ValidationException e) {
                e.printStackTrace();
            }
        }
    }

    public int asInt(){
        return Integer.parseInt(userAgreementNumber);
    }
}
