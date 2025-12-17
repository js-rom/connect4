package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public class UndoMachinePlayerCommand extends UndoCommand {

    public UndoMachinePlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        if (this.getReceiver().undoable()) {
            this.getReceiver().interruptDropToken();
            this.getReceiver().undo();
        }
    }
}