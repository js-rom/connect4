package connect4.views.graphics.gameLoop.play.commands;

public abstract class RedoCommand extends PlayPanelViewCommand {
    public RedoCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

}
