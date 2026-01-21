package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.core.StartController;

public class IsReset extends Dispatcher {

    public IsReset(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        boolean isReset = ((StartController) this.acceptorController).isReset();
        this.server.send(isReset);
    }

}
