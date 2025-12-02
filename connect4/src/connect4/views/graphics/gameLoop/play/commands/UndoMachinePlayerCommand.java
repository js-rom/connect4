package connect4.views.graphics.gameLoop.play.commands;

public class UndoMachinePlayerCommand extends UndoCommand {

    public UndoMachinePlayerCommand(PlayPanelViewVisitor receiver) {
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