package models;

import types.Color;
import utils.Coordinate;

public class RandomMachinePlayer extends MachinePlayer {
    
    public RandomMachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(PlayerVisitor visitor){
        visitor.visit(this);
    }

    public int getColumn(){
        int column;
        do {
            column = ((int)Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS ));
        } while (this.isComplete(column));
        return column;
    }

}
