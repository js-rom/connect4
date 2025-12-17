package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public class UndoUserPlayerCommand extends UndoCommand {

    public UndoUserPlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        if (this.getReceiver().undoable()) {
            this.getReceiver().undo();
        }
    }
}