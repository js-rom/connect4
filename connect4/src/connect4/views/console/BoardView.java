package connect4.views.console;

import utils.models.Coordinate;
import utils.views.Console;
import connect4.controllers.Controller;

public class BoardView {

    private Controller startController;

    public BoardView(Controller startController) {
        assert startController != null;
        this.startController = startController;
    }

    public void writeln() {
        this.writeHorizontal();
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                Console.getInstance()
                        .write(" " + this.startController.getColor(new Coordinate(i, j)).toString().charAt(0) + " ");
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
