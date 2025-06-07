package connect4.views.graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import java.awt.GridLayout;
import connect4.controllers.PlayController;
import connect4.types.Color;
import utils.models.Coordinate;

import java.util.EnumMap;
import java.util.Map;

public abstract class BoardView extends PanelView {

    public PlayController playController;
    private Map<Color, ImageIcon> colors;
    private PanelViewCommand nextTurnCommand;

    BoardView(PlayController playController) {
        this.playController = playController;
        this.setLayout(new GridLayout(Coordinate.NUMBER_ROWS, Coordinate.NUMBER_COLUMNS));
        this.colors = new EnumMap<>(Color.class);
        for (Color color : Color.values()) {
            String fileNamePrefix = "connect4\\src\\connect4\\views\\graphics\\assets\\";
            String fileNameInfix = color.toString().equals(" ") ? "White" : color.toString();
            String fileNameSufix = ".png";
            ImageIcon icon = new ImageIcon(fileNamePrefix + fileNameInfix + fileNameSufix);
            this.colors.put(color, icon);
        }
        this.write();
    }

    BoardView(PlayController playController, PanelViewCommand callback) {
        this(playController);
        assert (playController != null && callback != null);
        this.nextTurnCommand = callback;

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

    protected Map<Color, ImageIcon> getColors() {
        return this.colors;
    }

    public PanelViewCommand getNextTurnCommand() {
        return this.nextTurnCommand;
    }

    protected PlayController getPlayController() {
        return this.playController;
    }

    public abstract void accept(PlayPanelViewVisitor playPanelView);

}
