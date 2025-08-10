package connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import connect4.controllers.implementation.StartController;
import connect4.types.PlayerType;

public class AddPlayerDispatcher extends Dispatcher {

    public AddPlayerDispatcher(StartController startController) {
        super(startController);
    }

    @Override
    public void dispatch() {
        PlayerType playerType = null;
        try {
            playerType = this.server.receivePlayerType();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((StartController) this.acceptorController).addPlayer(playerType);
    }

}
