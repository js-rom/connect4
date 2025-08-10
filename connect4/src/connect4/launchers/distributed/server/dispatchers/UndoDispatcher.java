package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class UndoDispatcher extends Dispatcher {

    public UndoDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).undo();
    }

}
