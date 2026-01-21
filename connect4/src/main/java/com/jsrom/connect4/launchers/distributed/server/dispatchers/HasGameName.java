package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.implementation.SaveController;

public class HasGameName extends Dispatcher {

    public HasGameName(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        boolean hasName = ((SaveController) this.acceptorController).hasName();
        this.server.send(hasName);
    }

}
