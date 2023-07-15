package com.masai.problem2;

public class InvalidToyNumberException extends Exception{

    public InvalidToyNumberException() {
    }

    public InvalidToyNumberException(String message) {
        super(message);
    }
}
