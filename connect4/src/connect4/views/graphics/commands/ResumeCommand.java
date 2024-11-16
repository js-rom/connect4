package connect4.views.graphics.commands;

import connect4.views.View;

public class ResumeCommand implements Command {
    private View receiver;
    
    public ResumeCommand(View receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
       if(this.receiver.resume()) {
        this.receiver.start();
       } else {
        System.exit(0);
       }
    }
}
