package connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import connect4.controllers.implementation.PlayController;

public class IsComplete extends Dispatcher {

    public IsComplete(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int column = 0;
        try {
            column = this.server.receiveInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isComplete = ((PlayController) this.acceptorController).isComplete(column);
        this.server.send(isComplete);
    }

}
