package com.bluecodex.java.mastermind.model;

import java.util.List;

public interface IGame {

    public List<CodePeg> generateCode();
    public Boolean compareCodes(List<CodePeg> codePegs);


}
