package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class Redo extends Dispatcher {

    public Redo(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).redo();
    }

}
