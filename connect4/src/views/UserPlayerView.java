package views;

import models.Coordinate;
import models.Player;
import utils.console.Console;

public class UserPlayerView extends PlayerView {

    public UserPlayerView(Player player) {
        super(player);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            Message.TURN.write();
            Console.getInstance().writeln(this.getActivePlayer().getColor().toString());
            column = Console.getInstance().readInt(Message.ENTER_COLUMN_TO_DROP.toString()) - 1;
            valid = Coordinate.isColumnValid(column);
            if (!valid) {
                Message.INVALID_COLUMN.writeln();
            } else {
                valid = !this.getActivePlayer().isComplete(column);
                if (!valid) {
                    Message.COMPLETED_COLUMN.writeln();
                }
            }
        } while (!valid);
        return column;
    }
}
