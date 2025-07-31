package connect4.launchers.distributed.dispatchers;

import connect4.controllers.implementation.PlayController;

public class StateDispatcher extends Dispatcher {

    public StateDispatcher(PlayController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
	this.server.send(((PlayController)this.acceptorController).getValueState().ordinal());
    }

}
