package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import com.jsrom.connect4.controllers.core.AcceptorController;
import com.jsrom.connect4.controllers.implementation.StartController;

public class StartWithName extends Dispatcher {

    public StartWithName(AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        String gameName = "";
        try {
            gameName = this.server.receiveLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((StartController) this.acceptorController).start(gameName);
    }

}
