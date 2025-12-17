package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;

public class Reset extends Dispatcher {

    public Reset(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        ((StartController) this.acceptorController).reset();
    }

}
