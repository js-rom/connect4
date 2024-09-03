package models;

import types.Color;

public class Turn {
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;
    private Board board;
    private int playersSize;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.playersSize = 0;
    }

    public void reset() {
        this.playersSize = 0;
        this.activePlayer = 0;

    }

    public void setUserPlayer() {
        this.addPlayer(new UserPlayer(Color.get(playersSize), this.board));
    }

    public void setRandomMachinePlayer() {
        this.addPlayer(new RandomMachinePlayer(Color.get(playersSize), this.board));
    }

    private void addPlayer(Player player) {
        assert this.playersSize < Turn.NUMBER_PLAYERS;
        this.players[playersSize] = player;
        playersSize++;
    }

    public void next() {
        assert !this.board.isFinished();
        assert this.playersSize == Turn.NUMBER_PLAYERS;

        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;

    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

}
