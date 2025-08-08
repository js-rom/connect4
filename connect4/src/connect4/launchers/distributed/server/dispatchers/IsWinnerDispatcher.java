package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;

public class IsWinnerDispatcher extends Dispatcher {

    public IsWinnerDispatcher(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        boolean isWinner = ((PlayController) this.acceptorController).isWinner();
        this.server.send(isWinner);
    }

}
