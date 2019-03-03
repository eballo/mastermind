package com.bluecodex.java.mastermind.service.rest;

import com.bluecodex.java.mastermind.manager.GameManager;
import com.bluecodex.java.mastermind.model.code.CodePeg;
import com.bluecodex.java.mastermind.model.Game;
import com.bluecodex.java.mastermind.model.config.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
class MastermindController {

    @Autowired
    private GameManager gameManager;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Game gameCreate(@RequestParam(name = "guesses", required = false, defaultValue = "11") Integer guesses,
                           @RequestParam(name = "duplicates", required = false, defaultValue = "false") Boolean duplicates,
                           @RequestParam(name = "codeLength", required = false, defaultValue = "4") Integer codeLength) {
        GameConfig gameConfig = new GameConfig(guesses, duplicates, codeLength);
        return gameManager.gameCreate(gameConfig);
    }

    @RequestMapping(value = "/{gameId}/codemaker/create", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Game gameCreateCodeMaker(@PathVariable("gameId") String gameId) {
        return gameManager.gameCreateCodeMaker(gameId);
    }

    @RequestMapping(value = "/{gameId}/codebreaker/play", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Game gamePlay(@PathVariable("gameId") String gameId, @RequestBody List<CodePeg> codePegs) {
        return gameManager.gamePlay(gameId, codePegs);
    }

    @RequestMapping(value = "/{gameId}/status", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Game gameStatus(@PathVariable("gameId") String gameId) {
        return gameManager.gameStatus(gameId);
    }

}
