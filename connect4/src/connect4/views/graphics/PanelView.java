package connect4.views.graphics;

import javax.swing.JPanel;

import connect4.views.graphics.commands.Command;

public abstract class PanelView extends JPanel {
    private Command callback;

    protected abstract void write();

    public void setCallback(Command callback) {
        this.callback = callback;
    }
}
