package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.SaveController;

public class HasGameNameDispatcher extends Dispatcher {

    public HasGameNameDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        boolean hasName = ((SaveController) this.acceptorController).hasName();
        this.server.send(hasName);
    }

}
