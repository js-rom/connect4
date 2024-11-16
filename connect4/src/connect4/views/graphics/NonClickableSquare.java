package connect4.views.graphics;

import java.awt.event.ActionListener;

import javax.swing.Icon;

import utils.models.Coordinate;

public class NonClickableSquare extends ClickableSquare {
    private Coordinate coordinate;

    public NonClickableSquare(Icon icon) {
        super(icon);
    }

    public NonClickableSquare(Icon icon, Coordinate coordinate) {
        super(icon, coordinate);
    }

    public int getColumn() {
        return this.coordinate.getColumn();
    }

    public void addActionListener(ActionListener e) {
        assert (false);
    }
}
