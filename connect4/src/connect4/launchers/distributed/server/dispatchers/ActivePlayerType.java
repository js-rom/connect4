package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.PlayController;
import connect4.types.PlayerType;

public class ActivePlayerType extends Dispatcher {

    public ActivePlayerType(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        PlayerType activePlayerType = ((PlayController) this.acceptorController).getActivePlayerType();
        this.server.send(activePlayerType);
    }

}
