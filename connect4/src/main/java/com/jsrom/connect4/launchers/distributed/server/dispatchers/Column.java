package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

public class Column extends Dispatcher {

    public Column(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int column = ((PlayController) this.acceptorController).getColumn();
        this.server.send(column);
    }

}
