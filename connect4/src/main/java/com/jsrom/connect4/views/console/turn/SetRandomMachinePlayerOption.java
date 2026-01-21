package com.jsrom.connect4.views.console.turn;

import com.jsrom.connect4.controllers.core.StartController;
import com.jsrom.connect4.types.PlayerType;
import com.jsrom.connect4.views.console.shared.MenuOption;

public class SetRandomMachinePlayerOption extends MenuOption {
    public SetRandomMachinePlayerOption(StartController startController) {
        super(startController, "Easy Machine Player");
    }

    public void interact() {
        ((StartController) this.acceptorController).addPlayer(PlayerType.RANDOM_MACHINE_PLAYER);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
