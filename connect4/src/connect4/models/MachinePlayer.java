package connect4.models;

import connect4.types.Color;

public abstract class MachinePlayer extends Player {

    public MachinePlayer(Color color, Board board) {
        super(color, board);
    }

    public abstract void accept(PlayerVisitor visitor);

    public abstract int getColumn();
}
