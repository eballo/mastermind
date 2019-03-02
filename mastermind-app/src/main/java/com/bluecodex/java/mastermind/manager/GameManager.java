package com.bluecodex.java.mastermind.manager;

import com.bluecodex.java.mastermind.model.CodePeg;
import com.bluecodex.java.mastermind.model.Game;
import com.bluecodex.java.mastermind.model.GameConfig;
import com.bluecodex.java.mastermind.model.GamePlay;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class GameManager {

    private HashMap<String, Game> games;

    public GameManager() {
        this.games = new HashMap<String, Game>();
    }

    public Game gameCreate(GameConfig gameConfig){
        Game game = new Game(gameConfig);
        String id = game.getId();
        games.put(id, game);
        return game;
    }

    public Game gamePlay(String gameId, List<CodePeg> codePegs){
        Game game = games.get(gameId);
        game.play(codePegs);
        return game;
    }

    public void gameEnd(String gameId){
        games.remove(gameId);
    }

    public Game gameCreateCodeMaker(String gameId) {
        Game game = games.get(gameId);
        game.generateCode();
        return game;
    }

    public Game gameStatus(String gameId){
        return games.get(gameId);
    }

    public HashMap<String, Game> getGames() {
        return games;
    }
}
