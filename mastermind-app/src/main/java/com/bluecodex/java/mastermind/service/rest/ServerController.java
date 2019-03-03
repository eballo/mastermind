package com.bluecodex.java.mastermind.service.rest;

import com.bluecodex.java.mastermind.manager.GameManager;
import com.bluecodex.java.mastermind.model.server.ServerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @Autowired
    private GameManager gameManager;

    @RequestMapping(value = "/server/status", method = RequestMethod.GET)
    public ServerStatus serverStatus(){
        return gameManager.getServerStatus();
    }
}
