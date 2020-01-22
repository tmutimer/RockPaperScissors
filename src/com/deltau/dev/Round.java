package com.deltau.dev;

import java.util.Objects;

public class Round {
    enum Move {
        ROCK(1,3),
        PAPER(2,1),
        SCISSORS(3,2);

        private int value;
        private int beats;

        Move(int v, int b) { value = v; beats = b; }
        private int value() { return value; }
        private int beats() { return beats; }
    }

    enum Winner {
        COMPUTER, HUMAN, DRAW
    }

    public Move getPcMove() {
        return mPcMove;
    }

    public Move getHumanMove() {
        return mHumanMove;
    }

    private final Move mPcMove;
    private Move mHumanMove;
    private Winner mWinner;

    public Round(Move humanMove) {
        mPcMove = generatePcMove();
        mHumanMove = humanMove;
        mWinner = determineWinner();
    }

    private Move generatePcMove() {
        double randomDouble = Math.random() * 3;
        if(randomDouble <= 1) {
            return Move.ROCK;
        } else if (randomDouble > 1 && randomDouble <= 2) {
            return Move.PAPER;
        } else {
            return Move.SCISSORS;
        }
    }

    public Winner getWinner() { return mWinner; }

    private Winner determineWinner() {

        Objects.requireNonNull(mHumanMove, "Human has not decided yet");
        Objects.requireNonNull(mPcMove, "Computer has not decided yet");

        Winner winner;
        if(mHumanMove.value() == mPcMove.value()) {
            winner = Winner.DRAW;
        } else if(mHumanMove.beats() == mPcMove.value()) {
             winner = Winner.HUMAN;
        } else {
            winner = Winner.COMPUTER;
        }

        return winner;
    }

}
