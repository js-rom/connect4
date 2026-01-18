package com.jsrom.connect4.launchers.distributed.server.dispatchers;

import com.jsrom.connect4.controllers.implementation.PlayController;
import com.jsrom.connect4.types.Color;

public class ActiveColor extends Dispatcher {

    public ActiveColor(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        Color activeColor = ((PlayController) this.acceptorController).getActiveColor();
        this.server.send(activeColor);
    }

}
