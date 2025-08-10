package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class UndoableDispatcher extends Dispatcher {

    public UndoableDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isUndoable = ((PlayController) this.acceptorController).undoable();
        this.server.send(isUndoable);
    }

}
