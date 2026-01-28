package com.jsrom.connect4.models;

public class Memento {

    private String[] boardColors;
    private int activePlayer;

        Memento(Board board, Turn turn) {
        this.boardColors = board.toStringArray();
        this.activePlayer = turn.getActivePlayer().getColor().ordinal();
    }

    public Board getBoard() {
        return Board.fromStringArray(this.boardColors);
    }

    public int getActivePlayer() {
        return this.activePlayer;
    }
}
