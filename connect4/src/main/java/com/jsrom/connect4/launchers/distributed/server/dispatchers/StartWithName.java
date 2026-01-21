package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import main.java.com.jsrom.connect4.controllers.core.AcceptorController;
import main.java.com.jsrom.connect4.controllers.implementation.StartController;

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
