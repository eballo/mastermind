package com.bluecodex.java.mastermind.model.server;

import com.bluecodex.java.mastermind.model.Game;

import java.util.List;

public class ServerStatus {

    private Long activeGames;
    private Long totalGames;
    private Long finishedGames;
    private List<Game> gameList;

    public Long getActiveGames() {
        return activeGames;
    }

    public void setActiveGames(Long activeGames) {
        this.activeGames = activeGames;
    }

    public Long getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Long totalGames) {
        this.totalGames = totalGames;
    }

    public Long getFinishedGames() {
        return finishedGames;
    }

    public void setFinishedGames(Long finishedGames) {
        this.finishedGames = finishedGames;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }
}
