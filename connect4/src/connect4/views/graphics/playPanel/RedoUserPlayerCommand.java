package connect4.views.graphics.playPanel;

public class RedoUserPlayerCommand extends RedoCommand {

    public RedoUserPlayerCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().redo(this);
    }

}
