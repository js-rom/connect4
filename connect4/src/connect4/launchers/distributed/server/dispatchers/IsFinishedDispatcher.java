package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class IsFinishedDispatcher extends Dispatcher {

    public IsFinishedDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isFinished = ((PlayController)this.acceptorController).isFinished();
        this.server.send(isFinished);
    }
}
