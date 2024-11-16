package connect4.views.graphics;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import connect4.models.Game;
import connect4.models.Player;
import connect4.types.Color;

public class TurnView extends PanelView {

    Game game;
    private HashMap<Color, ImageIcon> colors;

    public TurnView(Game game) { // TODO DRY comun con BoardView
        this.game = game;
        // this.setLayout(new GridLayout(1, 1));
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

    public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }

    @Override
    protected void write() {
        this.removeAll();
        // this.setLayout(new GridLayout(1, Turn.NUMBER_PLAYERS));
        ImageIcon activeIcon = this.getColors().get(this.game.getActiveColor());
        this.add(new JLabel(Message.TURN.toString()));
        this.add(new JLabel(activeIcon));

    }

    protected HashMap<Color, ImageIcon> getColors() {
        return this.colors;
    }
}
