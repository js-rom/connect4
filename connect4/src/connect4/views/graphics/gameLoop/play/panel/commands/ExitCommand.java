package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public class ExitCommand extends PlayPanelViewCommand {

    public ExitCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().nextState();
        this.getReceiver().nextGameLoopView();
    }

}
