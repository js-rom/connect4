package connect4.views.graphics;

import connect4.views.graphics.commands.Command;

public abstract class PanelViewCommand implements Command {

    final PanelView receiver;

    public PanelViewCommand(PanelView receiver) {
        this.receiver = receiver;
    }

    protected PanelView getReceiver() {
        return this.receiver;
    }

}
