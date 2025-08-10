package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;

public class ResetDispatcher extends Dispatcher {

    public ResetDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        ((StartController) this.acceptorController).reset();
    }

}
