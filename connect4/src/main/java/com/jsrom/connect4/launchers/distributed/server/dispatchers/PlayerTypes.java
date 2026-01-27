package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.implementation.StartController;
import com.jsrom.connect4.types.PlayerType;

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
