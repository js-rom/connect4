package connect4.views.graphics;

import connect4.views.View;
import connect4.views.graphics.commands.Command;

public abstract class ViewCommand implements Command {

    final View receiver;

    public ViewCommand(View receiver) {
        this.receiver = receiver;
    }

    protected View getReceiver() {
        return this.receiver;
    }

    public abstract void execute();
}
