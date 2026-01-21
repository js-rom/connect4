package main.java.com.jsrom.connect4.models;

import main.java.com.jsrom.connect4.types.Color;

public abstract class MachinePlayer extends Player {

    public MachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public MachinePlayer() {
    
    }

    public abstract int getColumn();
}
