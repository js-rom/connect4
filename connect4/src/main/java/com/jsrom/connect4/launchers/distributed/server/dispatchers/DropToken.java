package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class DropToken extends Dispatcher {

    public DropToken(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int column = 0;
        try {
            column = this.server.receiveInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((PlayController) this.acceptorController).dropToken(column);

    }

}
