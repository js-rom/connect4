package connect4.views.graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import java.awt.GridLayout;
import connect4.controllers.PlayController;
import connect4.types.Color;
import connect4.views.graphics.commands.Command;
import utils.models.Coordinate;
import java.util.HashMap;

public abstract class BoardView extends PanelView {

    public PlayController playController;
    private HashMap<Color, ImageIcon> colors;
    private Command callback;

    public BoardView(PlayController playController) {
        this.playController = playController;
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
                Square square = this.createSquare(new Coordinate(i, j));
                square.setOpaque(true);
                Border border = BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY, 6);
                square.setBorder(border);
                square.setBackground(java.awt.Color.DARK_GRAY);
                this.add(square);
            }
        }
    }

    protected abstract Square createSquare(Coordinate coordiante);

    protected HashMap<Color, ImageIcon> getColors() {
        return this.colors;
    }

    public Command getCallback() {
        return this.callback;
    }

    protected PlayController getPlayController() {
        return this.playController;
    }

    public abstract void accept(PlayPanelViewVisitor playPanelView);

}
