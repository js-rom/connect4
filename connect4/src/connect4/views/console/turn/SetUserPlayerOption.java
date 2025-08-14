package connect4.views.console.turn;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;
import connect4.views.console.shared.MenuOption;

public class SetUserPlayerOption extends MenuOption {

    public SetUserPlayerOption(StartController startController) {
        super(startController, "Human player");
    }

    public void interact() {
         ((StartController) this.acceptorController).addPlayer(PlayerType.USER_PLAYER);
    }

    @Override
    public boolean isActive() {
        return true;
    }

}
