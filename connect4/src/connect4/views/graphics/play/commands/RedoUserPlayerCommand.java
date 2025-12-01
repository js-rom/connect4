package connect4.views.graphics.play.commands;

public class RedoUserPlayerCommand extends RedoCommand {

    public RedoUserPlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().redo(this);
    }

}
