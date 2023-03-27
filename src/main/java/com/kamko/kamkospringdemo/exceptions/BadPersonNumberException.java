package com.kamko.kamkospringdemo.exceptions;

public class BadPersonNumberException extends RuntimeException{
    public BadPersonNumberException(String message) {
        super(message);
    }
}
