package connect4.views.graphics.playPanel;

public class NextTurnCommand extends PlayPanelViewCommand {

    public NextTurnCommand(PlayPanelViewVisitor receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().write();
    }
}
