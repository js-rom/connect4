package connect4.views.graphics.commands;

import connect4.views.graphics.JFrameView;

public class NextTurnCommand implements Command {
    JFrameView receiver;

    public NextTurnCommand(JFrameView receiver) {
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
       this.receiver.interact();
    }
}


