package connect4.views.console.menus.turn;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(StartController startController) {
        super("Human player", startController);
    }

    public void interact() {
        this.startController.addPlayer(PlayerType.USER_PLAYER);
    }

}
