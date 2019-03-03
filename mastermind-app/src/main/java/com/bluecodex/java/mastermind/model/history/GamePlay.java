package com.bluecodex.java.mastermind.model.history;

import com.bluecodex.java.mastermind.model.code.CodePeg;
import com.bluecodex.java.mastermind.model.code.KeyPeg;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GamePlay {

    private List<CodePeg> codePegs;
    private List<KeyPeg> keyPegs;

    public GamePlay(List<CodePeg> codePegs, List<KeyPeg> keyPegs) {
        this.codePegs = codePegs;
        this.keyPegs = keyPegs;
    }

    public List<CodePeg> getCodePegs() {
        return codePegs;
    }

    public void setCodePegs(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    public List<KeyPeg> getKeyPegs() {
        return keyPegs;
    }

    public void setKeyPegs(List<KeyPeg> keyPegs) {
        this.keyPegs = keyPegs;
    }
}
