package connect4.views.graphics.commands;

import connect4.views.graphics.PanelView;
import connect4.views.graphics.PanelViewCommand;
import connect4.views.graphics.PlayPanelView;

public class UndoCommand extends PanelViewCommand {

    public UndoCommand(PanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        PlayPanelView playPanelView = (PlayPanelView) this.getReceiver();
        if(playPanelView.getPlayController().undoable()){
            playPanelView.getPlayController().undo();
            new NextTurnCommand(this.getReceiver()).execute();
        }
    }
}
