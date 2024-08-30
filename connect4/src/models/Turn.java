package models;

import types.Color;

public class Turn {
    private static int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        //this.reset(); //TODO calling without parameter, creo que sobra
    }

    public void reset(int userPlayers) {
        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = i < userPlayers ? 
                new UserPlayer(Color.get(i), this.board) : 
                new RandomMachinePlayer(Color.get(i), this.board);
        }
        this.activePlayer = 0;

    }

    public void next() {
        if (!this.board.isFinished()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public Player getActivePlayer(){
        return this.players[this.activePlayer];
    }
}
