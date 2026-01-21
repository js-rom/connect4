package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.SaveController;

public class Save extends Dispatcher {

    public Save(SaveController saveController) {
        super(saveController);
    }

    @Override
    public void dispatch() {
        ((SaveController) this.acceptorController).save();
    }

}
