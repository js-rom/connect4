package connect4.views.console.menus.options;

import connect4.controllers.StartController;
import connect4.types.PlayerType;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(StartController model) {
        super("Easy Machine Player", model);
    }

    public void interact() {
        this.model.addPlayer(PlayerType.RANDOM_MACHINE_PLAYER);
    }
}
