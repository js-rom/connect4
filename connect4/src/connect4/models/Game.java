package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class Game {

    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public boolean isReset() {
        return this.board.isReset() & this.turn.isReset();
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;
        return this.board.getColor(coordinate);
    }

    public boolean isWinner() {
        return this.board.isWinner();
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public Player getActivePlayer() {
        return this.turn.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.getActivePlayer().getType();
    }

    public Color getActiveColor() {
        return this.getActivePlayer().getColor();
    }

    public void next() {
        assert !this.isFinished();
        this.turn.next();
    }

    public int getNumberPlayers() {
        return Turn.NUMBER_PLAYERS;
    }

    public void addPlayer(PlayerType playerType) {
        this.turn.addPlayer(playerType);
    }

}
