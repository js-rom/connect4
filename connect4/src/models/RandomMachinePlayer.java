package models;

import views.TurnView;

public class RandomMachinePlayer extends MachinePlayer {
    
    public RandomMachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public void accept(TurnView visitor){ //OJOO el modelo se está acoplando a la vista
        visitor.visit(this);
    }

    public int getColumn(){
/*         int column;
        do {
            column = Math.floor(Math.random() * Coordinate.NUMBER_COLUMNS);
        } while (this.isComplete(column));
        return column; */
        return 1;
    }

}
