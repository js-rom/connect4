package connect4.views.graphics.gameLoop.play.commands;

public class UndoUserPlayerCommand extends UndoCommand {

    public UndoUserPlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        if (this.getReceiver().undoable()) {
            this.getReceiver().undo();
        }
    }
}