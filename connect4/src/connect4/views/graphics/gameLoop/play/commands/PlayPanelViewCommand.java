package connect4.views.graphics.gameLoop.play.commands;

public abstract class PlayPanelViewCommand implements Command {

    final PlayPanelViewVisitor receiver;

    public PlayPanelViewCommand(PlayPanelViewVisitor receiver) {
        this.receiver = receiver;
    }

    protected PlayPanelViewVisitor getReceiver() {
        return this.receiver;
    }

}
