package com.switchfully.order.security.exceptions;

public class CustomerDoesNotExistException extends RuntimeException{

    public CustomerDoesNotExistException(String message){
        super(message);
    }
}
