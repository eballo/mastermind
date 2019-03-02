package com.bluecodex.java.mastermind.model;

import java.util.List;

public interface IGame {

    public List<CodePeg> generateCode();
    public void compareCodes(List<CodePeg> codePegs);


}
