package main.java.com.jsrom.connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import main.java.com.jsrom.connect4.controllers.implementation.StartController;
import main.java.com.jsrom.connect4.types.PlayerType;

public class AddPlayer extends Dispatcher {

    public AddPlayer(StartController startController) {
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
