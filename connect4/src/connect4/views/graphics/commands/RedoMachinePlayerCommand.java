package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelView;

public class RedoMachinePlayerCommand extends RedoCommand {

    public RedoMachinePlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().redo(this);
    }

}
