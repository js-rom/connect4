package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.implementation.PlayController;

public class Redoable extends Dispatcher {

    public Redoable(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isRedoable = ((PlayController) this.acceptorController).redoable();
        this.server.send(isRedoable);
    }

}
