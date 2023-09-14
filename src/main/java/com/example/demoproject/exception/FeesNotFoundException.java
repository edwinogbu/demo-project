package com.example.demoproject.exception;


public class FeesNotFoundException extends RuntimeException{

    public FeesNotFoundException(Long id) {
        super("Could not find the fees with id: " + id);
    }


}
