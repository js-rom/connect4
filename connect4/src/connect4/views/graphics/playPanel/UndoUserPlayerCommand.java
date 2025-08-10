package connect4.views.graphics.playPanel;

public class UndoUserPlayerCommand extends UndoCommand {

    public UndoUserPlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
    }
}