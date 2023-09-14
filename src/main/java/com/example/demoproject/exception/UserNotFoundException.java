package com.example.demoproject.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Could not find the user with id: " + id);
    }

    public UserNotFoundException(String email) {
        super("Could not find the user with email: " + email);
    }
}
