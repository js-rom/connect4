package connect4.launchers.distributed.dispatchers;

import connect4.controllers.implementation.StartController;
import connect4.types.PlayerType;

public class PlayerTypesDispatcher extends Dispatcher {

    public PlayerTypesDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        PlayerType[] playerTypes = ((StartController) this.acceptorController).getPlayerTypes();
        this.server.send(playerTypes);
    }

}
