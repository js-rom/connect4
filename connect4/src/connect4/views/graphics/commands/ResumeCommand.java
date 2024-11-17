package connect4.views.graphics.commands;

import connect4.views.View;
import connect4.views.graphics.ViewCommand;

public class ResumeCommand extends ViewCommand {

    public ResumeCommand(View receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        if (this.getReceiver().resume()) {
            this.getReceiver().start();
        } else {
            System.exit(0);
        }
    }
}
