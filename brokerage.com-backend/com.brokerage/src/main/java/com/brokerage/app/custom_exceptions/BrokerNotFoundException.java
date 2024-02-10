package com.brokerage.app.custom_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BrokerNotFoundException extends Exception{
    public BrokerNotFoundException(String message){
        super(message);
    }
}
