package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelView;
import connect4.views.graphics.PlayPanelViewCommand;

public class NextTurnCommand extends PlayPanelViewCommand {

    public NextTurnCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().write();
    }
}
