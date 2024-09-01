package models;

import types.Color;

public class UserPlayer extends Player {

    public UserPlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(PlayerVisitor visitor){ //OJOO el modelo se está acoplando a la vista
        visitor.visit(this);
    }

}
