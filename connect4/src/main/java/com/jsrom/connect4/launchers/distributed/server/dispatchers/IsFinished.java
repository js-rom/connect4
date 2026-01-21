package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class IsFinished extends Dispatcher {

    public IsFinished(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isFinished = ((PlayController)this.acceptorController).isFinished();
        this.server.send(isFinished);
    }
}
