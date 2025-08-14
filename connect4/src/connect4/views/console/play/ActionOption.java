package connect4.views.console.play;

import connect4.controllers.core.PlayController;
import connect4.views.console.turn.TurnView;

public class ActionOption extends PlayOption {

    public ActionOption(PlayController playController) {
        super(playController, "Play Turn");
    }

    @Override
    public void interact() {
        new TurnView().dropToken((PlayController) this.acceptorController);
        super.interact();
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
