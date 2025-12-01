package connect4.views.graphics.gameLoop.play.board;

import javax.swing.Icon;
import utils.models.Coordinate;

public class ClickableSquare extends Square {

    public ClickableSquare(Icon icon) {
        super(icon);
    }

    public ClickableSquare(Icon icon, Coordinate coordinate) {
        super(icon, coordinate);
    }

    public int getColumn() {
        return this.coordinate.getColumn();
    }

}
