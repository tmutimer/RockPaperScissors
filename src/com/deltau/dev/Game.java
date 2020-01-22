package com.deltau.dev;

import java.util.ArrayList;

public class Game {
    enum State {
        IN_PROGRESS, WON, LOST
    }

    private State mState;

    private ArrayList<Round> mScoresheet;
    private int mPcScore;
    private int mHumanScore;
    private final int mFirstTo;

    public Game(int ft) {
        mFirstTo = ft;
        setInProgress();
        mScoresheet = new ArrayList<>();
    }

    public Round.Move[] playNewRound(Round.Move move) {
        Round currentRound = new Round(move);
        mScoresheet.add(currentRound);
        Round.Winner winner = currentRound.getWinner();
        if (winner == Round.Winner.HUMAN) {
            mHumanScore++;
        } else if (winner == Round.Winner.COMPUTER) {
            mPcScore++;
        }
        checkForWinner();
        return new Round.Move[] {currentRound.getHumanMove(), currentRound.getPcMove()};
    }

    public boolean inProgress() {
        return mState == State.IN_PROGRESS;
    }

    private void checkForWinner() {
        if(mHumanScore == mFirstTo) {
            mState = State.WON;
        } else if (mPcScore == mFirstTo) {
            mState = State.LOST;
        }
    }

    public int getHumanScore() {
        return mHumanScore;
    }

    public int getPcScore() {
        return mPcScore;
    }


    private void setInProgress() {
        mState = State.IN_PROGRESS;
    }

    public boolean isPlayerWinner() {
        return mState == State.WON;
    }

    public ArrayList<Round> getScoresheet() {
        return mScoresheet;
    }

}

