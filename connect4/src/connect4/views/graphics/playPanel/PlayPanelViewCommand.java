package connect4.views.graphics.playPanel;

import connect4.views.graphics.Command;

public abstract class PlayPanelViewCommand implements Command {

    final PlayPanelViewVisitor receiver;

    public PlayPanelViewCommand(PlayPanelViewVisitor receiver) {
        this.receiver = receiver;
    }

    protected PlayPanelViewVisitor getReceiver() {
        return this.receiver;
    }

}
