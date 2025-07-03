package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelViewCommand;
import connect4.views.graphics.PlayPanelView;

public class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
            this.getReceiver().redo();
    }
}
