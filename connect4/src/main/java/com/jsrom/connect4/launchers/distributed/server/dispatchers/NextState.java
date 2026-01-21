package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.core.AcceptorController;
import main.java.com.jsrom.connect4.controllers.core.Controller;

public class NextState extends Dispatcher {

    public NextState(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((Controller)this.acceptorController).nextState();
    }

}
