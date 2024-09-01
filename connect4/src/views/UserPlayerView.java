package views;

import utils.Coordinate;
import models.UserPlayer;
import utils.Console;

public class UserPlayerView implements PlayerView {

    private UserPlayer player;

    public UserPlayerView(UserPlayer player) {
        this.player = player;
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            Message.TURN.write();
            Console.getInstance().writeln(this.player.getColor().toString());
            column = Console.getInstance().readInt(Message.ENTER_COLUMN_TO_DROP.toString()) - 1;
            valid = Coordinate.isColumnValid(column);
            if (!valid) {
                String message = Message.INVALID_COLUMN.toString();
                message = message.replace("#maxColumns", String.valueOf(Coordinate.NUMBER_COLUMNS));
                Console.getInstance().writeln(message);
            } else {
                valid = !this.player.isComplete(column);
                if (!valid) {
                    Message.COMPLETED_COLUMN.writeln();
                }
            }
        } while (!valid);
        return column;
    }

    public void dropToken() {
        this.player.dropToken(this.getColumn());
    }
}
