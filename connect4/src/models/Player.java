package models;

import types.Color;
import views.TurnView;

public abstract class Player {
    private Color color;
    private Board board;

    Player(Color color, Board board) {
        this.color = color;
        this.board = board;        
    }

    public Color getColor(){
        return this.color;
    }

    public boolean isComplete(int column){
        return this.board.isComplete(column);
    }

    public void dropToken(int column){
        this.board.dropToken(column, this.color);
    }

    public abstract void accept(TurnView visitor); //OJOO el modelo se está acoplando a la vista
}
