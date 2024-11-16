package connect4.views.graphics.commands;

import connect4.views.graphics.JFrameView;

public class MakeInvisibleCommand implements Command{

    JFrameView receiver;

    public MakeInvisibleCommand(JFrameView receiver) {
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
       this.receiver.setVisible(false);
    }

}

