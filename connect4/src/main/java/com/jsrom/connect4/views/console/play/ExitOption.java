package main.java.com.jsrom.connect4.views.console.play;

import main.java.com.jsrom.connect4.controllers.core.PlayController;

public class ExitOption extends PlayOption {

    public ExitOption(PlayController playController) {
        super(playController, "Exit Game");
    }

    @Override
    public void interact() {
        ((PlayController) this.acceptorController).nextState();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
