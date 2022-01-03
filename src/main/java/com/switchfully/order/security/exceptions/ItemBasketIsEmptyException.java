package com.switchfully.order.security.exceptions;

public class ItemBasketIsEmptyException extends NullPointerException{
    public ItemBasketIsEmptyException(String message){
        super(message);
    }
}
