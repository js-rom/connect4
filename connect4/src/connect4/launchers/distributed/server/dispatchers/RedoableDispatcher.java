package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class RedoableDispatcher extends Dispatcher {

    public RedoableDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isRedoable = ((PlayController) this.acceptorController).redoable();
        this.server.send(isRedoable);
    }

}
