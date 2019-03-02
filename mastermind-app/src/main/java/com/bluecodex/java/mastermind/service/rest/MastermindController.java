package com.bluecodex.java.mastermind.service.rest;

import com.bluecodex.java.mastermind.manager.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
class MastermindController {

    @Autowired
    private GameManager gameManager;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String gameCreate() {
        return gameManager.gameCreate();
    }

    @RequestMapping(value = "/{gameId}/codemaker/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String gameCreateCodeMaker(@PathVariable("gameId") Long gameId) {
        return gameManager.gameCreateCodeMaker(gameId);
    }

    @RequestMapping(value = "/{gameId}/codebreaker/play", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void gamePlay(){

    }

    @RequestMapping(value = "/{gameId}/status", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void gameStatus(){

    }

}
