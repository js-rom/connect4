package connect4.views.graphics.commands;

import connect4.views.graphics.PlayPanelView;

public class UndoUserPlayerCommand extends UndoCommand {

    public UndoUserPlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
    }
}