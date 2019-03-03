package com.bluecodex.java.mastermind.model.code;

public enum CodePeg {
    BLUE,
    GREEN,
    YELLOW,
    ORANGE;

    public static CodePeg getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
