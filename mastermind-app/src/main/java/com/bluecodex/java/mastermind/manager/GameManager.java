package com.bluecodex.java.mastermind.manager;

import com.bluecodex.java.mastermind.model.CodePeg;

public class GameManager {

    // Default values for the game
    private Integer guesses = 10;
    private Boolean duplicates = true;
    private Integer codeLenght = 4;
    private Integer guessNum = 0;
    private CodePeg [] privateCode;

    public GameManager() {
    }

    public GameManager(Integer guesses, Boolean duplicates, Integer codeLenght) {
        this.guesses = guesses;
        this.duplicates = duplicates;
        this.codeLenght = codeLenght;
    }


}
