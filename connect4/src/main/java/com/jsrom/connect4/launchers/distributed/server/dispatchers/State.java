package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class State extends Dispatcher {

    public State(PlayController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
	this.server.send(((PlayController)this.acceptorController).getValueState().ordinal());
    }

}
