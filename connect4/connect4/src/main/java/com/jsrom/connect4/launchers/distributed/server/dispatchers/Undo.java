package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.implementation.PlayController;

public class Undo extends Dispatcher {

    public Undo(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((PlayController) this.acceptorController).undo();
    }

}
