package connect4.views.graphics.play.commands;

public abstract class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

}
