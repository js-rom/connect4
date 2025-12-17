package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class State extends Dispatcher {

    public State(PlayController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
	this.server.send(((PlayController)this.acceptorController).getValueState().ordinal());
    }

}
