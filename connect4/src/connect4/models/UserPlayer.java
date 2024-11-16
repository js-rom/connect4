package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;

public class UserPlayer extends Player {

    public UserPlayer(Color color, Board board) {
        super(color, board);
    }

    public UserPlayer() {
        
    }

    public void accept(PlayerVisitor visitor){
        visitor.visit(this);
    }

    public PlayerType getType() {
        return PlayerType.USER_PLAYER;
    }

}
