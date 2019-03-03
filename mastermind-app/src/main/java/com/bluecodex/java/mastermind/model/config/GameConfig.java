package com.bluecodex.java.mastermind.model.config;

import com.bluecodex.java.mastermind.exceptions.InvalidDataException;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameConfig {

    private Integer guesses;
    private Boolean duplicates;
    private Integer codeLength;

    public GameConfig(Integer guesses, Boolean duplicates, Integer codeLength) {
        if(validData(guesses, codeLength)) {
            this.guesses = guesses;
            this.duplicates = duplicates;
            this.codeLength = codeLength;
        }else{
            throw new InvalidDataException("Allowed rules: guesses parameter should be bigger than 0 and code length minimum should be 4");
        }
    }

    private boolean validData(Integer guesses, Integer codeLength) {
        return (guesses>0 && codeLength >=4);
    }

    public Integer getGuesses() {
        return guesses;
    }

    public void setGuesses(Integer guesses) {
        this.guesses = guesses;
    }

    public Boolean getDuplicates() {
        return duplicates;
    }

    public void setDuplicates(Boolean duplicates) {
        this.duplicates = duplicates;
    }

    public Integer getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(Integer codeLength) {
        this.codeLength = codeLength;
    }

    @Override
    public String toString() {
        return "GameConfig{" +
                "guesses=" + guesses +
                ", duplicates=" + duplicates +
                ", codeLength=" + codeLength +
                '}';
    }
}
