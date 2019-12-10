package com.demo.shoppingcart.exception;

public class DiscountNotFoundException extends RuntimeException {

    public DiscountNotFoundException(String message) {
        super(message);
    }
}
