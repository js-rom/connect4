package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelView;

public class UndoMachinePlayerCommand extends UndoCommand {

    public UndoMachinePlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
        }
    }