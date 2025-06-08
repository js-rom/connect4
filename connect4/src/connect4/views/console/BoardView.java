package connect4.views.console;

import utils.models.Coordinate;
import utils.views.Console;
import connect4.controllers.PlayController;

public class BoardView {

    private PlayController playController;

    public BoardView(PlayController playController) {
        assert playController != null;
        this.playController = playController;
    }

    public void writeln() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                Console.getInstance()
                        .write(" " + this.playController.getColor(new Coordinate(i, j)).toString().charAt(0) + " ");
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        this.writeHorizontal();
    }

    private void writeHorizontal() {
        for (int i = 0; i < 4 * Coordinate.NUMBER_COLUMNS; i++) {
            Message.HORIZONTAL_LINE.write();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
