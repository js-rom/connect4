package connect4.views.graphics;

import javax.swing.Icon;
import javax.swing.JButton;
import utils.models.Coordinate;

public class Square extends JButton {

    private Coordinate coordinate;

    public Square(Icon icon) {
        super(icon);
    }

    public Square(Icon icon, Coordinate coordinate) {
        super(icon);
        this.coordinate = coordinate;
    }

    public int getColumn() {
        return this.coordinate.getColumn();
    }

}
