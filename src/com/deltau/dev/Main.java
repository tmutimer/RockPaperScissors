package com.deltau.dev;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors.\n" +
                "Try to beat the computer!\n\n" +
                "Press enter to show last game results, or type a number of rounds to play to:");

        try {
            int input = 0;
            input = Integer.parseInt(String.valueOf((char) System.in.read()));

            if (input != 0) {
                Game game = new Game(input);
                do {
                    Round.Move[] moves = game.playNewRound(obtainHumanMove());
                    System.out.println();
                    System.out.println("You chose: " + moves[0]);
                    System.out.println("Computer chose: " + moves[1]);
                    System.out.println();
                    System.out.println("Scores:");
                    showScores(game);
                    System.out.println();
                    System.out.println();
                } while (game.inProgress());

                if(game.isPlayerWinner()) {
                    System.out.println("You won the game. Congratulations!");
                } else {
                    System.out.println("You lost the game. Sorry!");
                }
                System.out.println();
                System.out.println();
                System.out.println("Here's a summary:");
                System.out.println();
                showScoresheet(game);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static void showScores(Game game) {
        System.out.println("Human: " + game.getHumanScore() + "\nComputer: " + game.getPcScore());
    }

    private static void showScoresheet(Game game) {
        ArrayList<Round> scoresheet = game.getScoresheet();
        System.out.println("Your Move | Computer Move | Winner ");
        for (Round round: scoresheet) {
            Round.Move humanMove = round.getHumanMove();
            String humanMoveString= "";
            switch (humanMove) {
                case ROCK:
                    humanMoveString = "   Rock  ";
                    break;
                case PAPER:
                    humanMoveString = "   Paper ";
                    break;
                case SCISSORS:
                    humanMoveString = " Scissors";
                    break;
            }

            Round.Move pcMove = round.getPcMove();
            String pcMoveString = "";
            switch (pcMove) {
                case ROCK:
                    pcMoveString = "    Rock     ";
                    break;
                case PAPER:
                    pcMoveString = "    Paper    ";
                    break;
                case SCISSORS:
                    pcMoveString = "  Scissors   ";
                    break;
            }



            System.out.println(humanMoveString + " | " + pcMoveString + " | " + round.getWinner());
        }
    }

    public static Round.Move obtainHumanMove() {
        Round.Move humanMove;
        char inChar;

        System.out.println("Enter r, p or s for rock, paper or scissors, and press enter: ");

        try {
            int avoid;
            do {
                avoid = System.in.read();
            } while(avoid != '\n');
            inChar = (char) System.in.read();
            switch (inChar) {
                case 'r':
                    humanMove = Round.Move.ROCK;
                    break;
                case 'p':
                    humanMove = Round.Move.PAPER;
                    break;
                case 's':
                    humanMove = Round.Move.SCISSORS;
                    break;
                default:
                    throw new IOException();
            }
        } catch (IOException e) {
            return obtainHumanMove();
        }

        return humanMove;
    }
}
