package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;

public class NumberPlayers extends Dispatcher {

    public NumberPlayers(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        int numberPlayers = ((StartController) this.acceptorController).getNumberPlayers();
        this.server.send(numberPlayers);
    }

}
