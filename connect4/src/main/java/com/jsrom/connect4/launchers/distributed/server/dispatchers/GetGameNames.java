package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.StartController;

public class GetGameNames extends Dispatcher {

    public GetGameNames(main.java.com.jsrom.connect4.controllers.core.AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        String[] gameNames = ((StartController) this.acceptorController).getGameNames();
        this.server.send(gameNames);
    }
}
