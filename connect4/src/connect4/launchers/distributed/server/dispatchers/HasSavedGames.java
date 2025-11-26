package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;

public class HasSavedGames extends Dispatcher {

    public HasSavedGames(connect4.controllers.core.AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        boolean hasSavedGames = ((StartController) this.acceptorController).hasSavedGames();
        this.server.send(hasSavedGames);
    }

}
