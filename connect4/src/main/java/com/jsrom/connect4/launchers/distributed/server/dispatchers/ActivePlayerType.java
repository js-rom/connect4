package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;
import main.java.com.jsrom.connect4.types.PlayerType;

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
