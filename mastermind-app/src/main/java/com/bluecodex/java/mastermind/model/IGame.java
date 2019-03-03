package com.bluecodex.java.mastermind.model;

import com.bluecodex.java.mastermind.model.code.CodePeg;

import java.util.List;

public interface IGame {

    public List<CodePeg> generateCode();
    public Boolean compareCodes(List<CodePeg> codePegs);


}
