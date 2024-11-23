package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public abstract class Player {
    private Color color;
    private Board board;

    Player(Color color, Board board) {
        assert color != null && board != null;

        this.color = color;
        this.board = board;
    }

    Player() {

    }

    public Color getColor() {
        return this.color;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isComplete(int column) {
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;

        return this.board.isComplete(column);
    }

    public void dropToken(int column) {
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;
        assert !this.board.isComplete(column);

        this.board.dropToken(column, this.color);
    }

    public abstract PlayerType getType();
}
