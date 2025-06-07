package connect4.views.graphics;

import java.util.EnumMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import connect4.controllers.PlayController;
import connect4.types.Color;

public class TurnView extends PanelView {

    private PlayController playController;
    private Map<Color, ImageIcon> colors;

    public TurnView(PlayController playController) { // TODO DRY comun con BoardView
        assert (playController != null);
        this.playController = playController;
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

    @Override
    public void write() {
        this.removeAll();
        ImageIcon activeIcon = this.getColors().get(this.playController.getActiveColor());
        this.add(new JLabel(Message.TURN.toString()));
        this.add(new JLabel(activeIcon));

    }

    protected Map<Color, ImageIcon> getColors() {
        return this.colors;
    }

}
