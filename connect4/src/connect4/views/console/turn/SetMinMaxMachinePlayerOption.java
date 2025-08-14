package connect4.views.console.turn;

import connect4.controllers.core.StartController;
import connect4.types.PlayerType;
import connect4.views.console.shared.MenuOption;

public class SetMinMaxMachinePlayerOption extends MenuOption {

    public SetMinMaxMachinePlayerOption(StartController startController) {
        super(startController, "Dificult Machine Player");
    }

    public void interact() {
        ((StartController) this.acceptorController).addPlayer(PlayerType.MIN_MAX_MACHINE_PLAYER);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
