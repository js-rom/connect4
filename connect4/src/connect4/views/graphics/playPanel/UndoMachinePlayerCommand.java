package connect4.views.graphics.playPanel;

public class UndoMachinePlayerCommand extends UndoCommand {

    public UndoMachinePlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
        }
    }