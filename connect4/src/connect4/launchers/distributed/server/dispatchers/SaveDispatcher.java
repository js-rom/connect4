package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.SaveController;

public class SaveDispatcher extends Dispatcher {

    public SaveDispatcher(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        ((SaveController) this.acceptorController).save();
    }

}
