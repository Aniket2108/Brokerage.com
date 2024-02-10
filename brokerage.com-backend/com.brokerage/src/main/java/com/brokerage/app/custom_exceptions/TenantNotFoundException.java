package com.brokerage.app.custom_exceptions;

public class TenantNotFoundException extends Exception{
    public TenantNotFoundException(String message){
        super(message);
    }
}
