package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;

public class GetGameNames extends Dispatcher {

    public GetGameNames(connect4.controllers.core.AcceptorController acceptorController) {
        super(acceptorController);
    }

    @Override
    public void dispatch() {
        String[] gameNames = ((StartController) this.acceptorController).getGameNames();
        this.server.send(gameNames);
    }
}
