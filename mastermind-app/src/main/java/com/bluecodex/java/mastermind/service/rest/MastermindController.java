package com.bluecodex.java.mastermind.service.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MastermindController {

    @RequestMapping(value = "/server/activity", method = RequestMethod.GET)
    public void getActicveGames(){

    }

    @RequestMapping(value = "/game/create", method = RequestMethod.POST)
    public String createGame() {
        return "create";
    }

    @RequestMapping(value = "/game/{gameId}/play", method = RequestMethod.POST)
    public void play(){

    }

    @RequestMapping(value = "/game/{gameId}/status", method = RequestMethod.GET)
    public void status(){

    }

}
