package connect4.views.console.menus.options;

import connect4.models.Turn;
import connect4.types.PlayerType;

public class SetUserPlayerOption extends TurnOption {

    public SetUserPlayerOption(Turn model) {
        super("Human player", model);
    }

    public void interact() {
        this.model.addPlayer(PlayerType.USER_PLAYER);
    }

}
