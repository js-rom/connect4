package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import com.jsrom.connect4.controllers.implementation.SaveController;

public class SetGameName extends Dispatcher {

    public SetGameName(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        String name = "";
        try {
            name = this.server.receiveLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((SaveController) this.acceptorController).setName(name);
    }

}
