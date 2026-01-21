package main.java.com.jsrom.connect4.views.console.play;

import main.java.com.jsrom.connect4.controllers.core.PlayController;
import main.java.com.jsrom.connect4.views.console.turn.TurnView;

public class ActionOption extends PlayOption {

    public ActionOption(PlayController playController) {
        super(playController, "Play Turn");
    }

    @Override
    public void interact() {
        new TurnView().dropToken((PlayController) this.acceptorController);
        super.interact();
        if (((PlayController) this.acceptorController).isFinished()) {
            new TurnView().writeResult((PlayController) this.acceptorController);
            ((PlayController) this.acceptorController).nextState();
        }
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
