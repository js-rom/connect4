package main.java.com.jsrom.connect4.models;

import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.PlayerType;

public class UserPlayer extends Player {

    public UserPlayer(Color color, Board board) {
        super(color, board);
    }

    public UserPlayer() {

    }

    public PlayerType getType() {
        return PlayerType.USER_PLAYER;
    }

}
