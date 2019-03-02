package com.bluecodex.java.mastermind.service.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @RequestMapping(value = "/server/status", method = RequestMethod.GET)
    public void serverStatus(){

    }
}
