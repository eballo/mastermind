package com.bluecodex.java.mastermind.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "GameId not found")
public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException() {
    }

    public GameNotFoundException(String message) {
        super(message);
    }
}
