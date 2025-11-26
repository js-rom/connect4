package connect4.launchers.distributed.server.dispatchers;

import connect4.controllers.implementation.StartController;
import connect4.types.PlayerType;

public class PlayerTypes extends Dispatcher {

    public PlayerTypes(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        PlayerType[] playerTypes = ((StartController) this.acceptorController).getPlayerTypes();
        this.server.send(playerTypes);
    }

}
