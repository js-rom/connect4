package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelViewCommand;
import connect4.views.graphics.PlayPanelView;

public abstract class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelView receiver) {
        super(receiver);
    }

}
