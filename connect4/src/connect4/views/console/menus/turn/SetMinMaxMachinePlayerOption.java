package connect4.views.console.menus.turn;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;

public class SetMinMaxMachinePlayerOption extends TurnOption {

    public SetMinMaxMachinePlayerOption(StartController startController) {
        super("Dificult Machine Player", startController);
    }

    public void interact() {
        this.startController.addPlayer(PlayerType.MIN_MAX_MACHINE_PLAYER);
    }
}
