package connect4.views.graphics.commands;

import connect4.views.graphics.PanelView;
import connect4.views.graphics.PanelViewCommand;
import connect4.views.graphics.PlayPanelView;

public class RedoCommand extends PanelViewCommand {
    public RedoCommand(PanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        PlayPanelView playPanelView = (PlayPanelView) this.getReceiver();
        if(playPanelView.getPlayController().redoable()){
            playPanelView.getPlayController().redo();
            new NextTurnCommand(this.getReceiver()).execute();
        }
    }
}
