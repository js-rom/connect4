package connect4.views.graphics;

import connect4.views.graphics.commands.Command;

public abstract class PlayPanelViewCommand implements Command {

    final PlayPanelView receiver;

    public PlayPanelViewCommand(PlayPanelView receiver) {
        this.receiver = receiver;
    }

    protected PlayPanelView getReceiver() {
        return this.receiver;
    }

}
