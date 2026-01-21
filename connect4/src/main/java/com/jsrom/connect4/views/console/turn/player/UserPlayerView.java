package main.java.com.jsrom.connect4.views.console.turn.player;

import main.java.com.jsrom.connect4.controllers.core.PlayController;
import main.java.com.jsrom.connect4.views.console.shared.Message;

import main.java.com.jsrom.utils.models.Coordinate;
import main.java.com.jsrom.utils.views.Console;

public class UserPlayerView extends PlayerView {

    public UserPlayerView(PlayController playController) {
        super(playController);
    }

    public int getColumn() {
        int column;
        boolean valid;
        do {
            column = Console.getInstance().readInt(Message.ENTER_COLUMN_TO_DROP.toString()) - 1;
            valid = Coordinate.isColumnValid(column);
            if (!valid) {
                String message = Message.INVALID_COLUMN.toString();
                message = message.replace("#maxColumns", String.valueOf(Coordinate.NUMBER_COLUMNS));
                Console.getInstance().writeln(message);
            } else {
                valid = !this.playController.isComplete(column);
                if (!valid) {
                    Message.COMPLETED_COLUMN.writeln();
                }
            }
        } while (!valid);
        return column;
    }

    public void dropToken() {
        this.playController.dropToken(this.getColumn());
    }

    public PlayerView copy() {
        return new UserPlayerView(this.playController);
    }
}
