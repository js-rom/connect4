package connect4.views.graphics.play.commands;

public class UndoMachinePlayerCommand extends UndoCommand {

    public UndoMachinePlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().undo(this);
        }
    }