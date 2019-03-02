package com.bluecodex.java.mastermind.model;

public class ServerStatus {

    private Integer activeGames;
    private Integer totalGames;
    private Integer finishedGames;

    public Integer getActiveGames() {
        return activeGames;
    }

    public void setActiveGames(Integer activeGames) {
        this.activeGames = activeGames;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    public Integer getFinishedGames() {
        return finishedGames;
    }

    public void setFinishedGames(Integer finishedGames) {
        this.finishedGames = finishedGames;
    }
}
