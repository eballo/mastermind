package com.bluecodex.java.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid data")
public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {
    }

    public InvalidDataException(String message) {
        super(message);
    }

}
