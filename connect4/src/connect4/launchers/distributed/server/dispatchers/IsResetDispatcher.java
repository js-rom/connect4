package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.core.StartController;

public class IsResetDispatcher extends Dispatcher {

    public IsResetDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        boolean isReset = ((StartController) this.acceptorController).isReset();
        this.server.send(isReset);
    }

}
