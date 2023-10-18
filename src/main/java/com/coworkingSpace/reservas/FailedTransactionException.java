package com.coworkingSpace.reservas;

public class FailedTransactionException extends RuntimeException{
    public FailedTransactionException(String s){
        super("Transaction failed: "+s);
    }
    }

