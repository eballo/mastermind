package com.bluecodex.java.mastermind.model;

import com.bluecodex.java.mastermind.exceptions.GameNotFoundException;
import com.bluecodex.java.mastermind.exceptions.InvalidDataException;
import com.bluecodex.java.mastermind.model.code.CodePeg;
import com.bluecodex.java.mastermind.model.code.KeyPeg;
import com.bluecodex.java.mastermind.model.config.GameConfig;
import com.bluecodex.java.mastermind.model.history.GamePlay;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game implements IGame {

    private String id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Boolean finished;
    @JsonSerialize(using = ToStringSerializer.class)
    private Boolean win;
    private GameConfig gameConfiguration;
    private Integer guessNum = 0;
    private List<CodePeg> privateCode;
    private HashMap<Integer, GamePlay> history;

    public Game(GameConfig gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
        this.finished = Boolean.FALSE;
        this.history = new HashMap<>();
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

    public Boolean compareCodes(List<CodePeg> codePegs) {
        return (Boolean) Arrays.equals(new List[]{codePegs}, new List[]{privateCode});
    }

    public void play(List<CodePeg> codePegs) {

        validateCodeBreaker(codePegs);

        GamePlay gamePlay = getKeyPegs(codePegs);
        this.history.put(getGuessNum(), gamePlay);
        this.incrementGuess();

        if(compareCodes(codePegs)){
            gameWin();
        }else {
            if (guessNum.equals(gameConfiguration.getGuesses())) {
                gameOver();
            }
        }

    }

    public GamePlay getKeyPegs(List<CodePeg> codePegs){
        List<KeyPeg> keyPegs = new ArrayList<>();

        for (int i=0; i< codePegs.size(); i++){
            KeyPeg keyPeg = null;
            for(int j=0; j< privateCode.size(); j++){
                if(codePegs.get(i).equals(privateCode.get(j))){
                    if(i == j){
                        keyPeg = KeyPeg.BLACK;
                        break;
                    }else {
                        keyPeg = KeyPeg.WHITE;
                    }
                }
            }
            keyPegs.add(keyPeg);
        }

        GamePlay gamePlay = new GamePlay(codePegs,keyPegs);
        return gamePlay;
    }

    public void incrementGuess(){
        this.guessNum = this.guessNum + 1;
    }

    public String getId() {
        return id;
    }

    public List<CodePeg> getPrivateCode() {
        return privateCode;
    }

    public void setPrivateCode(List<CodePeg> privateCode) {
        if(privateCode.size()!= gameConfiguration.getCodeLength()) {
            throw new InvalidDataException("Invalid length for the codemaker must be "+gameConfiguration.getCodeLength());
        }
        this.privateCode = privateCode;
    }

    public GameConfig getGameConfiguration() {
        return gameConfiguration;
    }

    public Integer getGuessNum() {
        return guessNum;
    }

    public HashMap<Integer, GamePlay> getHistory() {
        return history;
    }

    public void setHistory(HashMap<Integer, GamePlay> history) {
        this.history = history;
    }

    private void validateCodeBreaker(List<CodePeg> codePegs) {
        if(this.finished){
            throw new GameNotFoundException("The game status is finished, you can't play this game");
        }

        if(privateCode == null){
            throw new InvalidDataException("the code maker was not created! Create a codebreaker first!");
        }

        if(codePegs.size()!=privateCode.size()){
            throw new InvalidDataException("The given codebreaker have an invalid size, must be"+privateCode.size());
        }
    }

    private void gameWin() {
        this.finished = Boolean.TRUE;
        this.win = Boolean.TRUE;
    }

    public void gameOver() {
        this.finished = Boolean.TRUE;
        this.win = Boolean.FALSE;
    }

    public Boolean getFinished() {
        return finished;
    }

    public Boolean getWin() {
        return win;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", finished=" + finished +
                ", win=" + win +
                ", gameConfiguration=" + gameConfiguration +
                ", guessNum=" + guessNum +
                ", privateCode=" + privateCode +
                ", history=" + history +
                '}';
    }
}
