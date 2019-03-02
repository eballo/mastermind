package com.bluecodex.java.mastermind.model;

public enum CodePeg {
    BLUE,
    GREEN,
    YELLOW,
    ORANGE;

    public static CodePeg getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
