package connect4.views.graphics.gameLoop.play.commands;

public abstract class UndoCommand extends PlayPanelViewCommand  {

    public UndoCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

}
