package connect4.views.console.menus.options;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;

public class SetRandomMachinePlayerOption extends TurnOption {
    public SetRandomMachinePlayerOption(StartController startController) {
        super("Easy Machine Player", startController);
    }

    public void interact() {
        this.startController.addPlayer(PlayerType.RANDOM_MACHINE_PLAYER);
    }
}
