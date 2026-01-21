package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.StartController;

public class HasSavedGames extends Dispatcher {

    public HasSavedGames(main.java.com.jsrom.connect4.controllers.core.AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        boolean hasSavedGames = ((StartController) this.acceptorController).hasSavedGames();
        this.server.send(hasSavedGames);
    }

}
