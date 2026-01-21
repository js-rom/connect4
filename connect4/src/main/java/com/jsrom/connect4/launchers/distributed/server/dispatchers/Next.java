package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class Next extends Dispatcher {

    public Next(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).next();
    }

}
