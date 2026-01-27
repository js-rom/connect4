package com.jsrom.connect4.views.console.turn;

import com.jsrom.connect4.controllers.core.StartController;

import com.jsrom.utils.models.menu.SecuentialMenu;

public class TurnMenu extends SecuentialMenu {

    private StartController startController;

    public TurnMenu(StartController startController, int maxSecuences) {
        super("Elige un tipo de jugador: ", maxSecuences);
        this.startController = startController;
    }

    @Override
    public void addOptions() {
        this.add(new SetUserPlayerOption(this.startController));
        this.add(new SetRandomMachinePlayerOption(this.startController));
        this.add(new SetMinMaxMachinePlayerOption(this.startController));
    }

}
