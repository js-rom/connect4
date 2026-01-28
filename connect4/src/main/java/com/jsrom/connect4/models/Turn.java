package com.jsrom.connect4.models;

import com.jsrom.connect4.types.Color;
import com.jsrom.connect4.types.PlayerType;

public class Turn {
    public static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayerIndex;
    private Board board;
    private int playersSize;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.playersSize = 0;
    }

    public void reset() {
        this.playersSize = 0;
        this.activePlayerIndex = 0;

    }

    public void addPlayer(PlayerType playerType) {
        assert this.playersSize < Turn.NUMBER_PLAYERS;
        PlayerPrototype playerProtoype = new PlayerPrototype();
        Player player = playerProtoype.getPlayer(playerType);
        player.setColor(Color.get(playersSize));
        player.setBoard(this.board);
        this.players[playersSize] = player;
        playersSize++;
    }

    public void next() {
        assert !this.board.isFinished();
        assert this.playersSize == Turn.NUMBER_PLAYERS;

        this.activePlayerIndex = (this.activePlayerIndex + 1) % Turn.NUMBER_PLAYERS;

    }

    public Player getActivePlayer() {
        return this.players[this.activePlayerIndex];
    }

    public String getPlayerTypeName(int index) {
        assert index >= 0 && index < this.playersSize;
        return this.players[index].getType().name();
    }

    public String getPlayerColorName(int index) {
        assert index >= 0 && index < this.playersSize;
        return this.players[index].getColor().name();
    }

    public void setActivePlayer(int activePlayerIndex) {
        assert activePlayerIndex >= 0 && activePlayerIndex < Turn.NUMBER_PLAYERS;
        this.activePlayerIndex = activePlayerIndex;
    }

    public int getActivePlayerIndex() {
        return this.activePlayerIndex;
    }

    public boolean isReset() {
        return this.playersSize == 0;
    }

    public void setBoard(Board board) {
        assert board != null;
        assert players != null;
        this.board = board;
        for (Player player : players) {
            player.setBoard(board);
        }
    }

    public int getPlayersSize() {
        return this.playersSize;
    }

    public void setPlayersSize(int size) {
        this.playersSize = size;
    }
}
