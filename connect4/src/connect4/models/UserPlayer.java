package connect4.models;

import connect4.types.Color;

public class UserPlayer extends Player {

    public UserPlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(PlayerVisitor visitor){
        visitor.visit(this);
    }

}
