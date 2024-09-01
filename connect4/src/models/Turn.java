package models;

import types.Color;

public class Turn {
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
    }

    public void reset(int userPlayers) {
        assert 0 <= userPlayers && userPlayers <= Turn.NUMBER_PLAYERS;

        for (int i = 0; i < Turn.NUMBER_PLAYERS; i++) {
            this.players[i] = i < userPlayers ? new UserPlayer(Color.get(i), this.board)
                    : new RandomMachinePlayer(Color.get(i), this.board);
        }
        this.activePlayer = 0;

    }

    public void next() {
        assert !this.board.isFinished();

        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;

    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

}
