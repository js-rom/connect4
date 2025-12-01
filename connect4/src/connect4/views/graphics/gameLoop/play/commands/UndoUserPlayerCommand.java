package connect4.views.graphics.gameLoop.play.commands;

public class UndoUserPlayerCommand extends UndoCommand {

    public UndoUserPlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
    }
}