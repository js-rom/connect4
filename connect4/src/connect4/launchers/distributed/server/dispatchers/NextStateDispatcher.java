package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.core.AcceptorController;
import connect4.controllers.core.Controller;

public class NextStateDispatcher extends Dispatcher {

    public NextStateDispatcher(AcceptorController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        ((Controller)this.acceptorController).nextState();
    }

}
