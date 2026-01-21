package main.java.com.jsrom.connect4.models;

import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.PlayerType;

import main.java.com.jsrom.utils.models.Coordinate;

public class RandomMachinePlayer extends MachinePlayer {

    public RandomMachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public RandomMachinePlayer() {

    }

    public int getColumn() {
        int column;
        do {
            column = ((int) Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS));
        } while (this.isComplete(column));
        return column;
    }

    public PlayerType getType() {
        return PlayerType.RANDOM_MACHINE_PLAYER;
    }

}
