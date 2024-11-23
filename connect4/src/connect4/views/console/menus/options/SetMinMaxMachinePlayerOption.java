package connect4.views.console.menus.options;

import connect4.controllers.StartController;
import connect4.types.PlayerType;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(StartController model) {
        super("Dificult Machine Player", model);
    }

    public void interact() {
        this.model.addPlayer(PlayerType.MIN_MAX_MACHINE_PLAYER);
    }
}
