package connect4.views.console.menus.play;

import connect4.controllers.core.PlayController;
import connect4.views.console.TurnView;

public class ActionOption extends PlayOption {

    public ActionOption(PlayController playController) {
        super(playController, "Play Turn");
    }

    @Override
    public void interact() {
        new TurnView().dropToken(this.playController);
        super.interact();
    }

    @Override
    public boolean isActive() {
       return true;
    }

}
