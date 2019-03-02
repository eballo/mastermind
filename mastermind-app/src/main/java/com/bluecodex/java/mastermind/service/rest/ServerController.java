package com.bluecodex.java.mastermind.service.rest;

import com.bluecodex.java.mastermind.manager.GameManager;
import com.bluecodex.java.mastermind.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ServerController {

    @Autowired
    private GameManager gameManager;

    @RequestMapping(value = "/server/status", method = RequestMethod.GET)
    public HashMap<String, Game> serverStatus(){
        return gameManager.getGames();
    }
}
