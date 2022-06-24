package com.erick.creditcard.exceptions;

public class CreditException extends RuntimeException {

    public CreditException(Throwable throwable) {
        super(throwable);
    }

    public CreditException(String msg) {
        super(msg);
    }

}