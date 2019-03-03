package com.bluecodex.java.mastermind.manager;

import com.bluecodex.java.mastermind.exceptions.GameNotFoundException;
import com.bluecodex.java.mastermind.exceptions.InvalidDataException;
import com.bluecodex.java.mastermind.model.Game;
import com.bluecodex.java.mastermind.model.code.CodePeg;
import com.bluecodex.java.mastermind.model.config.GameConfig;
import com.bluecodex.java.mastermind.model.history.GamePlay;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManagerTest {

    @Test
    public void gameCreateGoodGame(){
        Integer guesses = 1;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        gameManager.gameCreate(config);

    }

    @Test (expected = GameNotFoundException.class)
    public void gamePlayNonExistingGame(){
        Integer guesses = 1;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        gameManager.gameCreate(config);

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.YELLOW);
        codebreaker.add(CodePeg.GREEN);

        gameManager.gamePlay("nonExisitingGameId",codebreaker);

    }

    @Test (expected = InvalidDataException.class)
    public void gamePlayExistingGameNonExistingCodeMaker(){
        Integer guesses = 1;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        Game game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.YELLOW);
        codebreaker.add(CodePeg.GREEN);

        gameManager.gamePlay(gameId,codebreaker);

    }

    @Test (expected = InvalidDataException.class)
    public void gamePlayExistingGameExistingCodeMakerAndCodeBreakerDifferentSize(){
        Integer guesses = 1;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        Game game = gameManager.gameCreate(config);
        String gameId = game.getId();

        gameManager.gameCreateCodeMaker(gameId);

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.YELLOW);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        gameManager.gamePlay(gameId,codebreaker);

    }

    @Test (expected = InvalidDataException.class)
    public void gamePlayExistingGameExistingBadCodeMakerSize(){
        Integer guesses = 1;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        Game game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);
        codeMaker.add(CodePeg.GREEN);

        gameManager.gameCreateCodeMaker(gameId, codeMaker);

    }

    @Test
    public void gamePlayExistingGameExistingGoodCodeMakerSize(){
        Game game = null;
        Integer guesses = 11;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),1);
        Assert.assertEquals(game.getFinished(), Boolean.FALSE);

    }

    @Test
    public void gamePlayExistingGameExistingGoodCodeMakerSizeFinishGameAndWin(){
        Game game = null;
        Integer guesses = 11;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),1);
        Assert.assertEquals(game.getFinished(), Boolean.FALSE);

        List<CodePeg> codebreaker2 = new ArrayList<>();
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.YELLOW);
        codebreaker2.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker2);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),2);
        Assert.assertEquals(game.getFinished(), Boolean.TRUE);
        Assert.assertEquals(game.getWin(), Boolean.TRUE);

    }

    @Test
    public void gamePlayExistingGameExistingGoodCodeMakerSizeFinishGameAndGameOver(){
        Game game = null;
        Integer guesses = 2;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),1);
        Assert.assertEquals(game.getFinished(), Boolean.FALSE);

        List<CodePeg> codebreaker2 = new ArrayList<>();
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.ORANGE);
        codebreaker2.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker2);
        Assert.assertEquals(game.getGuessNum().intValue(),2);
        Assert.assertEquals(game.getHistory().size(),2);
        Assert.assertEquals(game.getFinished(), Boolean.TRUE);
        Assert.assertEquals(game.getWin(), Boolean.FALSE);

    }

    @Test (expected = GameNotFoundException.class)
    public void gamePlayExistingGameExistingGoodCodeMakerSizeFinishGameAndGameOverAndTryToPlay(){
        Game game = null;
        Integer guesses = 2;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),1);
        Assert.assertEquals(game.getFinished(), Boolean.FALSE);

        List<CodePeg> codebreaker2 = new ArrayList<>();
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.ORANGE);
        codebreaker2.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker2);
        Assert.assertEquals(game.getGuessNum().intValue(),2);
        Assert.assertEquals(game.getHistory().size(),2);
        Assert.assertEquals(game.getFinished(), Boolean.TRUE);
        Assert.assertEquals(game.getWin(), Boolean.FALSE);

        List<CodePeg> codebreaker3 = new ArrayList<>();
        codebreaker3.add(CodePeg.BLUE);
        codebreaker3.add(CodePeg.BLUE);
        codebreaker3.add(CodePeg.ORANGE);
        codebreaker3.add(CodePeg.GREEN);

        gameManager.gamePlay(gameId,codebreaker2);

    }

    @Test
    public void getHistory(){
        Game game = null;
        Integer guesses = 2;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        List<CodePeg> codebreaker = new ArrayList<>();
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.BLUE);
        codebreaker.add(CodePeg.GREEN);
        codebreaker.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker);
        Assert.assertEquals(game.getGuessNum().intValue(),1);
        Assert.assertEquals(game.getHistory().size(),1);
        Assert.assertEquals(game.getFinished(), Boolean.FALSE);

        List<CodePeg> codebreaker2 = new ArrayList<>();
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.BLUE);
        codebreaker2.add(CodePeg.ORANGE);
        codebreaker2.add(CodePeg.GREEN);

        game = gameManager.gamePlay(gameId,codebreaker2);
        Assert.assertEquals(game.getGuessNum().intValue(),2);
        Assert.assertEquals(game.getHistory().size(),2);
        Assert.assertEquals(game.getFinished(), Boolean.TRUE);
        Assert.assertEquals(game.getWin(), Boolean.FALSE);

        HashMap<Integer, GamePlay> history = gameManager.gameHistory(gameId);
        Assert.assertEquals(history.size(),2);

    }

    @Test
    public void getStatus(){
        Game game = null;
        Integer guesses = 2;
        Boolean duplicate = Boolean.TRUE;
        Integer codeLength = 4;
        GameConfig config = new GameConfig(guesses, duplicate, codeLength);

        GameManager gameManager = new GameManager();
        game = gameManager.gameCreate(config);
        String gameId = game.getId();

        List<CodePeg> codeMaker = new ArrayList<>();
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.BLUE);
        codeMaker.add(CodePeg.YELLOW);
        codeMaker.add(CodePeg.GREEN);

        game = gameManager.gameCreateCodeMaker(gameId, codeMaker);
        Assert.assertNotNull(game.getPrivateCode());

        Boolean isActive = gameManager.gameStatus(gameId);

        Assert.assertEquals(isActive,true);

    }
}