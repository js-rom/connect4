package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.core.AcceptorController;
import com.jsrom.connect4.controllers.core.Controller;

public class NextState extends Dispatcher {

    public NextState(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((Controller)this.acceptorController).nextState();
    }

}
