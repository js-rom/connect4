package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public abstract class UndoCommand extends PlayPanelViewCommand  {

    public UndoCommand(PlayPanelView receiver) {
        super(receiver);
    }

}
