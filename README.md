# RockPaperScissors
A simple CLI rock-paper-scissors game implemented in Java in just a few hours.

The user can choose how many rounds to play at the beginning. Throughout, the game will remind the user of the score, and at the end it will show a play-by-play of the game.

My focus in this exercise was to embrace the object-oriented style as fully as possible, and within that, to ensure the code was encapsulated in the most logical way. Writing and reading from the command line was taken care of in main(), while all game mechanics were delegated to the Game and Round classes.

One challenge of this exercise was to find a simple way to determine the winner of a given round. My solution to this was to use an enum type Move, which would specify for each move which other move it would beat.

    enum Move {
        ROCK(1,3),
        PAPER(2,1),
        SCISSORS(3,2);

        private int value;
        private int beats;
        
        ...
    }
    
Aside from being fairly concise, I liked this solution because it avoided hard-coding the logic for each move, so the rules of the game could be expanded without too much effort (e.g. adding Lizard and Spock).
