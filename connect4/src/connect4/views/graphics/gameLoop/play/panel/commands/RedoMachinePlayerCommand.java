package connect4.views.graphics.gameLoop.play.panel.commands;

import connect4.views.graphics.gameLoop.play.panel.PlayPanelView;

public class RedoMachinePlayerCommand extends RedoCommand {

    public RedoMachinePlayerCommand(PlayPanelView receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().interruptDropToken();
        this.getReceiver().redo();
    }

}
