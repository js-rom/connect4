package connect4.views.graphics.playPanel;

public class RedoMachinePlayerCommand extends RedoCommand {

    public RedoMachinePlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().redo(this);
    }

}
