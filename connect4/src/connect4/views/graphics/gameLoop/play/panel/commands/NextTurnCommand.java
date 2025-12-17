package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public class NextTurnCommand extends PlayPanelViewCommand {

    public NextTurnCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().write();
    }
}
