package connect4.views.console.menus.options;

import connect4.controllers.StartController;
import connect4.types.PlayerType;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(StartController model) {
        super("Human player", model);
    }

    public void interact() {
        this.model.addPlayer(PlayerType.USER_PLAYER);
    }

}
