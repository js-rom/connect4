package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import main.java.com.jsrom.connect4.controllers.implementation.PlayController;

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
