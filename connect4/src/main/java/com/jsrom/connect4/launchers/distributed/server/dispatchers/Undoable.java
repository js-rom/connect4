package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class Undoable extends Dispatcher {

    public Undoable(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isUndoable = ((PlayController) this.acceptorController).undoable();
        this.server.send(isUndoable);
    }

}
