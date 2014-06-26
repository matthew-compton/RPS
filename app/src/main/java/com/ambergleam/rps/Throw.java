package com.ambergleam.rps;

/**
 * Created by ambergleam
 */
public enum Throw {

    ROCK,
    PAPER,
    SCISSORS;

    public boolean defeats(Throw t) {
        if (this == ROCK && t == SCISSORS) {
            return true;
        }
        if (this == PAPER && t == ROCK) {
            return true;
        }
        if (this == SCISSORS && t == PAPER) {
            return true;
        }
        return false;
    }

}
