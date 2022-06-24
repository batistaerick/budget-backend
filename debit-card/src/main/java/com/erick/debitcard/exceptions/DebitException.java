package com.erick.debitcard.exceptions;

public class DebitException extends RuntimeException {

    public DebitException(Throwable throwable) {
        super(throwable);
    }

    public DebitException(String msg) {
        super(msg);
    }

}