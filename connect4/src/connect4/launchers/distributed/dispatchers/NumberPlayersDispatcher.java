package connect4.launchers.distributed.dispatchers;

import connect4.controllers.implementation.StartController;

public class NumberPlayersDispatcher extends Dispatcher {

    public NumberPlayersDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        int numberPlayers = ((StartController) this.acceptorController).getNumberPlayers();
        this.server.send(numberPlayers);
    }

}
