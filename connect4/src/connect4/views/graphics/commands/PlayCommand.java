package connect4.views.graphics.commands;

import connect4.views.View;
import connect4.views.graphics.ViewCommand;

public class PlayCommand extends ViewCommand {

    public PlayCommand(View receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        this.getReceiver().play();
    }
}
