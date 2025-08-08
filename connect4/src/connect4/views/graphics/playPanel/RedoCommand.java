package connect4.views.graphics.playPanel;

public abstract class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

}
