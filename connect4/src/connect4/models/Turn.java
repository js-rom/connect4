package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;

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

        this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;

    }

    public Player getActivePlayer() {
        return this.players[this.activePlayer];
    }

    public boolean isReset() {
        return this.playersSize == 0;
    }
}
