package connect4.views.graphics;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import connect4.models.Game;
import connect4.types.Color;
import utils.models.Coordinate;
import java.util.HashMap;

public abstract class BoardView extends PanelView {

    private Game game;
    private HashMap<Color, ImageIcon> colors;

    public BoardView(Game game) {
        this.game = game;
        this.setLayout(new GridLayout(Coordinate.NUMBER_ROWS, Coordinate.NUMBER_COLUMNS));
        this.colors = new HashMap<Color, ImageIcon>();
        for (Color color : Color.values()) {
            String fileNamePrefix = "connect4\\src\\connect4\\views\\graphics\\assets\\";
            String fileNameInfix = color.toString() == " " ? "White" : color.toString();
            String fileNameSufix = ".png";
            ImageIcon icon = new ImageIcon(fileNamePrefix + fileNameInfix + fileNameSufix);
            this.colors.put(color, icon);
        }
        this.write();
    }

    protected Game getGame() {
        return this.game;
    }

    protected HashMap<Color, ImageIcon> getColors() {
        return this.colors;
    }

    protected abstract void write();

    public abstract BoardView copy();

}
