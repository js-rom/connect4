package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public abstract class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelView receiver) {
        super(receiver);
    }

}
