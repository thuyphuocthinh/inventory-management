package com.tpt.inventory_management.exception;

public class NameValueRequiredException extends RuntimeException {
    public NameValueRequiredException(String message) {
        super(message);
    }
}
