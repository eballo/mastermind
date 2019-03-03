package com.bluecodex.java.mastermind.model;

import com.bluecodex.java.mastermind.exceptions.InvalidDataException;
import com.bluecodex.java.mastermind.model.config.GameConfig;
import org.junit.Test;

public class GameTest {

    @Test (expected = InvalidDataException.class)
    public void createGameBadConfiguration(){
        Integer guesses = 0;
        Integer codeLength = 0;

        GameConfig config = new GameConfig(guesses, Boolean.TRUE, codeLength);
        Game game = new Game(config);
    }

    @Test
    public void createGameGoodConfiguration(){
        Integer guesses = 1;
        Integer codeLength = 4;

        GameConfig config = new GameConfig(guesses, Boolean.TRUE, codeLength);
        Game game = new Game(config);
    }

}