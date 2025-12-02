package connect4.views.graphics.gameLoop.play.commands;

public class RedoMachinePlayerCommand extends RedoCommand {

    public RedoMachinePlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().interruptDropToken();
        this.getReceiver().redo();
    }

}
