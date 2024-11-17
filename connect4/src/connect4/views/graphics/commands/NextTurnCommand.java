package connect4.views.graphics.commands;

import connect4.views.graphics.PanelView;
import connect4.views.graphics.PanelViewCommand;

public class NextTurnCommand extends PanelViewCommand {

    public NextTurnCommand(PanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().write();
    }
}
