package connect4.views.graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import java.awt.GridLayout;
import connect4.models.Game;
import connect4.types.Color;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;
import java.util.HashMap;

public abstract class BoardView extends PanelView {

    private HashMap<Color, ImageIcon> colors;
    private Command callback;

    public BoardView(Game game) {
        super(game);
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

   public void write() {
        this.removeAll();
        this.setLayout(new GridLayout(Coordinate.NUMBER_ROWS, Coordinate.NUMBER_COLUMNS));
        for (int i = Coordinate.NUMBER_ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                ImageIcon icon = this.getColors().get(this.getGame().getColor(new Coordinate(i, j)));
                Coordinate coordiante = new Coordinate(i, j);
                Square square = this.createSquare(icon, coordiante);
                square.setOpaque(true);
                Border border = BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 6);
                square.setBorder(border);
                square.setBackground(java.awt.Color.DARK_GRAY);
                this.add(square);
            }
        }
    }

    protected abstract Square createSquare(ImageIcon icon, Coordinate coordiante);

    public abstract BoardView copy();

    protected Game getGame() {
        return this.game;
    }

    protected HashMap<Color, ImageIcon> getColors() {
        return this.colors;
    }

    public Command getCallback() {
        return this.callback;
    }

}
