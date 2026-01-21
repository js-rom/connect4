package com.jsrom.connect4.views.console.turn;

import com.jsrom.connect4.controllers.core.StartController;
import com.jsrom.connect4.types.PlayerType;
import com.jsrom.connect4.views.console.shared.MenuOption;

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
