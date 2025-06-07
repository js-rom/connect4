package connect4.views.graphics;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import utils.models.Coordinate;

public class NonClickableSquare extends Square {

    public NonClickableSquare(Icon icon) {
        super(icon);
    }

    public NonClickableSquare(Icon icon, Coordinate coordinate) {
        super(icon, coordinate);
    }

    @Override
    public void addActionListener(ActionListener e) {
        // prevents adding an action, as this square is non-clickable.
    }
}
