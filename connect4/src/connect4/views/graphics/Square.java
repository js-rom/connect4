package connect4.views.graphics;

import javax.swing.Icon;
import javax.swing.JButton;

import utils.models.Coordinate;

public abstract class Square extends JButton {
    protected Coordinate coordinate;

    public Square(Icon icon) {
        super(icon);
        this.setBorderPainted(false);
    }

    public Square(Icon icon, Coordinate coordinate) {
        this(icon);
        this.coordinate = coordinate;
    }

    public abstract int getColumn();

}
