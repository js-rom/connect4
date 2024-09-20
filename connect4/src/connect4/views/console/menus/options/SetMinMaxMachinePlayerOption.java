package connect4.views.console.menus.options;

import connect4.models.Turn;
import connect4.types.PlayerType;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(Turn model) {
        super("Dificult Machine Player", model);
    }

    public void interact() {
        this.model.addPlayer(PlayerType.MIN_MAX_MACHINE_PLAYER);
    }
}
