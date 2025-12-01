package connect4.views.graphics.gameLoop.play.commands;

public class NextTurnCommand extends PlayPanelViewCommand {

    public NextTurnCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().write();
    }
}
