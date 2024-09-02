package models;

import types.Color;
import utils.Coordinate;
import views.TurnView;

public abstract class Player {
    private Color color;
    private Board board;

    Player(Color color, Board board) {
        assert color != null && board != null;

        this.color = color;
        this.board = board;        
    }

    public Color getColor(){
        return this.color;
    }

    public boolean isComplete(int column){
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;

        return this.board.isComplete(column);
    }

    public void dropToken(int column){
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;
        assert !this.board.isComplete(column);
        
        this.board.dropToken(column, this.color);
    }

    public abstract void accept(PlayerVisitor visitor);
}