package connect4.views.graphics.commands;

import connect4.views.View;

public class PlayCommand implements Command {

    private View receiver;
    
    public PlayCommand(View receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
       this.receiver.play();
    }
}
