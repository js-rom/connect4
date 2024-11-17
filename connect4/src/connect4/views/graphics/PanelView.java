package connect4.views.graphics;

import javax.swing.JPanel;

import connect4.models.Game;
import connect4.views.graphics.commands.Command;

public abstract class PanelView extends JPanel {

    Game game;
    private Command callback;

    public PanelView(Game game) {
        this.game = game;
    }

    public abstract void write();

    public void setCallback(Command callback) {
        this.callback = callback;
    }

    public Command getCallback() {
        return this.callback;
    }

}
