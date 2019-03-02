package com.bluecodex.java.mastermind.model;

public class Game implements IGame {

    // Default values for the game
    private Integer guesses = 10;
    private Boolean duplicates = true;
    private Integer codeLenght = 4;
    private Integer guessNum = 0;
    private CodePeg [] privateCode;

    public Game() {
    }

    public Game(Integer guesses, Boolean duplicates, Integer codeLenght) {
        this.guesses = guesses;
        this.duplicates = duplicates;
        this.codeLenght = codeLenght;
    }

    public CodePeg[] generateCode() {
        return null;
    }

    public void compareCodes() {

    }

    public CodePeg[] getPrivateCode() {
        return privateCode;
    }

    public void setPrivateCode(CodePeg[] privateCode) {
        this.privateCode = privateCode;
    }
}
