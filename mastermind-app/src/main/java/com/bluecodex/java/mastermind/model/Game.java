package com.bluecodex.java.mastermind.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game implements IGame {

    private String id;
    private Boolean finished = Boolean.FALSE;
    private GameConfig gameConfiguration;
    private Integer guessNum = 0;
    private List<CodePeg> privateCode;

    public Game(GameConfig gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
        this.finished = Boolean.FALSE;
        this.id = UUID.randomUUID().toString();
    }

    public List<CodePeg> generateCode() {
        privateCode = new ArrayList<CodePeg>(gameConfiguration.getCodeLength());

        for(int i =0; i < gameConfiguration.getCodeLength(); i++){
            privateCode.add(getPegCode());
        }

        return privateCode;
    }

    private CodePeg getPegCode(){
        final CodePeg codePeg = CodePeg.getRandom();
        if(!gameConfiguration.getDuplicates()) {
            boolean match = privateCode.stream().anyMatch(peg -> peg.equals(codePeg));
            if (match) {
                return getPegCode();
            }
        }
        return codePeg;
    }

    public void compareCodes(List<CodePeg> codePegs) {
        
    }

    public String getId() {
        return id;
    }

    public List<CodePeg> getPrivateCode() {
        return privateCode;
    }

    public void setPrivateCode(List<CodePeg> privateCode) {
        this.privateCode = privateCode;
    }

    public GameConfig getGameConfiguration() {
        return gameConfiguration;
    }

    public Integer getGuessNum() {
        return guessNum;
    }
}
