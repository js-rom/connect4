package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public abstract class PlayPanelViewCommand implements Command {

    final PlayPanelView receiver;

    public PlayPanelViewCommand(PlayPanelView receiver) {
        this.receiver = receiver;
    }

    protected PlayPanelView getReceiver() {
        return this.receiver;
    }

}
