package com.bluecodex.java.mastermind.manager;

import com.bluecodex.java.mastermind.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameManager {

    private Game game;


    public String gameCreate(){
        game = new Game();
        return  "bla";
    }

    public void gamePlay(){

    }

    public void gameEnd(){

    }

    public String gameCreateCodeMaker(Long gameId) {
        game.generateCode();
        return "bla";
    }
}
