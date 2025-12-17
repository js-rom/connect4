package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class IsWinner extends Dispatcher {

    public IsWinner(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isWinner = ((PlayController) this.acceptorController).isWinner();
        this.server.send(isWinner);
    }

}
