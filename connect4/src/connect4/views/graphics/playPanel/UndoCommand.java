package connect4.views.graphics.playPanel;

public abstract class UndoCommand extends PlayPanelViewCommand  {

    public UndoCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

}
